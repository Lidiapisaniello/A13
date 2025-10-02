package com.example.db_setup.service;

import com.example.db_setup.model.GameProgress;
import com.example.db_setup.model.Opponent;
import com.example.db_setup.model.Player;
import com.example.db_setup.model.PlayerProgress;
import com.example.db_setup.model.repository.GameProgressRepository;
import com.example.db_setup.model.repository.PlayerProgressRepository;
import com.example.db_setup.model.repository.PlayerRepository;
import com.example.db_setup.service.exception.GameProgressNotFoundException;
import com.example.db_setup.service.exception.PlayerProgressNotFoundException;
import com.example.db_setup.service.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testrobotchallenge.commons.models.opponent.GameMode;
import testrobotchallenge.commons.models.opponent.OpponentDifficulty;
import testrobotchallenge.commons.models.opponent.OpponentType;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Service che gestisce le statistiche dei giocatori relative a:
 * <ul>
 *     <li>I punti esperienza guadagnati;</li>
 *     <li>Gli avversari battuti;</li>
 *     <li>Gli achievement sbloccati.</li>
 * </ul>
 * <p>
 * Fornisce metodi per la creazione, il recupero e l’aggiornamento dei progressi
 * del giocatore.
 * </p>
 */
@Service
public class PlayerProgressService {

    private final PlayerProgressRepository playerProgressRepository;
    private final PlayerRepository playerRepository;
    private final GameProgressRepository gameProgressRepository;
    private final OpponentService opponentService;

    private static final Logger logger = LoggerFactory.getLogger(PlayerProgressService.class);


    public PlayerProgressService(PlayerProgressRepository playerProgressRepository, PlayerRepository playerRepository, GameProgressRepository gameProgressRepository, OpponentService opponentService) {
        this.playerProgressRepository = playerProgressRepository;
        this.playerRepository = playerRepository;
        this.gameProgressRepository = gameProgressRepository;
        this.opponentService = opponentService;
    }

    /**
     * Crea un nuovo {@link PlayerProgress} per un giocatore appena registrato.
     *
     * @param player    il giocatore per cui creare il progresso
     * @return          il progresso creato
     */
    @Transactional
    public PlayerProgress createNewPlayerProgress(Player player) {
        PlayerProgress playerProgress = new PlayerProgress(player);
        return playerProgressRepository.save(playerProgress);
    }

    /**
     * Recupera il {@link PlayerProgress} associato a un player a partire dal suo ID.
     *
     * @param playerId      identificativo del giocatore
     * @return              il {@link PlayerProgress} del giocatore
     * @throws UserNotFoundException            se il giocatore non esiste
     * @throws PlayerProgressNotFoundException  se il progresso non è stato trovato
     */
    public PlayerProgress getProgressByPlayerId(long playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isEmpty()) {
            logger.error("[ERROR] Player with id {} not found", playerId);
            throw new UserNotFoundException();
        }

        Optional<PlayerProgress> progress = playerProgressRepository.findByPlayer(player.get());
        if (progress.isEmpty()) {
            logger.error("[ERROR] PlayerProgress for player with id {} not found", playerId);
            throw new PlayerProgressNotFoundException();
        }

        return progress.get();
    }

    /**
     * Recupera il {@link GameProgress} del giocatore contro un determinato avversario.
     *
     * @param playerId      l'id del giocatore
     * @param gameMode      la modalità di gioco
     * @param classUT       la classe sotto test
     * @param type          la tipologia di avversario
     * @param difficulty    la difficoltà dell’avversario
     * @return              il {@link GameProgress} corrispondente
     * @throws GameProgressNotFoundException    se non esiste alcun {@link GameProgress} associato al player e/o all'avversario
     */
    public GameProgress getPlayerGameProgressAgainstOpponent(long playerId, GameMode gameMode, String classUT, OpponentType type, OpponentDifficulty difficulty) {
        Optional<GameProgress> gameProgress = gameProgressRepository.findByPlayerAndOpponentParams(playerId, gameMode, classUT, type, difficulty);
        if (gameProgress.isEmpty())
            throw new GameProgressNotFoundException();

        return gameProgress.get();
    }

    /**
     * Restituisce i punti esperienza totali di un player.
     *
     * @param playerId      id del player
     * @return              i punti esperienza accumulati
     */
    public int getPlayerExperience(long playerId) {
        PlayerProgress progress = getProgressByPlayerId(playerId);
        return progress.getExperiencePoints();
    }

    /**
     * Restituisce tutti gli achievement globali di un player.
     *
     * @param playerId      l'id del player
     * @return              gli achievement globali sbloccati dal player
     */
    public Set<String> getPlayerGlobalAchievements(long playerId) {
        PlayerProgress progress = getProgressByPlayerId(playerId);
        return progress.getGlobalAchievements();
    }

    /**
     * Aggiorna i punti esperienza di un giocatore con l’esperienza guadagnata.
     *
     * @param playerId      l'id del giocatore
     * @param gainedExp     l'esperienza guadagnata
     * @return              i nuovi punti esperienza totali
     */
    public int updatePlayerExperience(long playerId, int gainedExp) {
        PlayerProgress progress = getProgressByPlayerId(playerId);
        progress.setExperiencePoints(progress.getExperiencePoints() + gainedExp);
        playerProgressRepository.save(progress);

        return progress.getExperiencePoints();
    }

    /**
     * Crea (se non esiste già) un {@link GameProgress} per un giocatore
     * contro un determinato avversario.
     *
     * @param playerId      l'id del giocatore
     * @param gameMode      la modalità di gioco
     * @param classUT       la classe sotto test
     * @param type          la tipologia di avversario
     * @param difficulty    la difficoltà dell'avversario
     * @return              il {@link GameProgress} esistente o creato
     */
    public GameProgress createPlayerGameProgressAgainstOpponent(long playerId, GameMode gameMode, String classUT,
                                                                OpponentType type, OpponentDifficulty difficulty) {

        PlayerProgress progress = getProgressByPlayerId(playerId);
        Opponent opponent = opponentService.getOpponent(gameMode, classUT, type, difficulty);

        Optional<GameProgress> exists = gameProgressRepository.getGameProgressByPlayerProgressAndOpponent(progress, opponent);
        return exists.orElseGet(() -> gameProgressRepository.save(new GameProgress(progress, opponent)));
    }

    /**
     * Aggiorna il {@link GameProgress} del giocatore contro un avversario,
     * segnando l’eventuale nuova vittoria e aggiungendo gli achievement sbloccati.
     *
     * @param playerId              l'id del giocatore
     * @param gameMode              la modalità di gioco
     * @param classUT               la classe sotto test
     * @param type                  la tipologia di avversario
     * @param difficulty            la difficoltà dell'avversario
     * @param isWinner              indica se il giocatore ha vinto
     * @param unlockedAchievements  i nuovi achievement da sbloccare
     * @return un {@link Pair} contenente:
     *         <ul>
     *             <li>{@code Boolean}: true se il giocatore è vincitore;</li>
     *             <li>{@code Set<String>}: l'insieme di nuovi achievement sbloccati in questa partita.</li>
     *         </ul>
     */
    public Pair<Boolean, Set<String>> updatePlayerGameProgressAgainstOpponent(long playerId, GameMode gameMode, String classUT, OpponentType type,
                                                        OpponentDifficulty difficulty, boolean isWinner, Set<String> unlockedAchievements) {

        // Recupero il gameProgress associato al giocatore e all'avversario passati
        GameProgress gameProgress = getPlayerGameProgressAgainstOpponent(playerId, gameMode, classUT, type, difficulty);
        // Recupero gli achievement già sbloccati dal giocatore contro l'avversario
        Set<String> alreadyUnlocked = new HashSet<>(gameProgress.getAchievements());
        // Estraggo gli achievement sbloccati nella partita corrente che non sono ancora stati sbloccati
        Set<String> newlyUnlocked = unlockedAchievements.stream()
                .filter(achievement -> !alreadyUnlocked.contains(achievement))
                .collect(Collectors.toSet());

        // Aggiorno il gameProgress con l'eventuale vittoria e gli eventuali nuovi achievement sbloccati
        gameProgress.getAchievements().addAll(newlyUnlocked);
        logger.info("Setting winner as {}", gameProgress.isWinner() || isWinner);
        gameProgress.setWinner(gameProgress.isWinner() || isWinner);
        gameProgressRepository.save(gameProgress);

        // Restituisco l'eventuale vittoria e i nuovi achievement sbloccati
        return Pair.of(gameProgress.isWinner(), newlyUnlocked);
    }

    /**
     * Aggiorna gli achievement globali di un giocatore, aggiungendo quelli che non erano ancora stati sbloccati.
     *
     * @param playerId              l'id del giocatore
     * @param unlockedAchievements  gli achievement sbloccati nella partita
     * @return                      il {@link Set} di nuovi achievement sbloccati nella partita
     */
    @Transactional
    public Set<String> updatePlayerGlobalAchievements(long playerId, Set<String> unlockedAchievements) {
        // Recupero il playerProgress associato all'utente
        PlayerProgress progress = getProgressByPlayerId(playerId);
        // Recupero gli achievement globali già sbloccati fino a questo momento
        Set<String> alreadyUnlocked = new HashSet<>(progress.getGlobalAchievements());
        // Dagli achievement globali sbloccati nella patita estraggo quelli nuovi (mai sbloccati fino a questo momento)
        Set<String> newlyUnlocked = new HashSet<>();
        if (unlockedAchievements != null) {
            newlyUnlocked = unlockedAchievements.stream()
                    .filter(achievement -> !alreadyUnlocked.contains(achievement))
                    .collect(Collectors.toSet());
        }

        // Aggiorno lo stato registrando i nuovi achievement sbloccati
        progress.getGlobalAchievements().addAll(newlyUnlocked);

        // Restituisco i nuovi achievement sbloccati
        return newlyUnlocked;
    }

}
