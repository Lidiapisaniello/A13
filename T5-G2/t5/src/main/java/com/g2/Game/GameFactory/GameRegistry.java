package com.g2.Game.GameFactory;
import java.util.Map;

import com.g2.Game.GameFactory.params.GameParams;
import org.springframework.stereotype.Component;

import com.g2.Game.GameModes.GameLogic;
import com.g2.Interfaces.ServiceManager;

/*
 *  Quando chiamiamo createGame("Sfida", ...), Spring trova automaticamente la factory corretta. grazie ai Bean
 *  Espandibilità → Per aggiungere un nuovo gioco, basta creare una nuova factory con l'interfaccia GameFactoryFunction
 *  con @Component('nome modalità')
 */
@Component
public class GameRegistry {
    /*
     * Quando si dichiara una mappa con il tipo Map<String, GameFactoryFunction>, 
     * Spring popola automaticamente la mappa con tutte le istanze di GameFactoryFunction disponibili nel contesto,
     *  usando il nome del bean come chiave.
     */
    private final Map<String, GameFactoryFunction> gameRegistry;

    // Spring raccoglie tutte le factory automaticamente e le inietta nella mappa
    public GameRegistry(Map<String, GameFactoryFunction> gameFactories) {
        this.gameRegistry = gameFactories;
        /*
         * Stampo tutte le chiavi all'avvio
         */
        System.out.println("Factory registrate: " + gameFactories.keySet());
    }

    /*
    public GameLogic createGame(String mode, ServiceManager sm, 
                                String playerId, String underTestClassName, 
                                String type_robot, String difficulty) {
                        
        GameFactoryFunction factory = gameRegistry.get(mode);
        if (factory == null) {
            throw new IllegalArgumentException("Gioco non registrato: " + mode);
        }

        return factory.create(sm, playerId, underTestClassName, type_robot, difficulty, mode);
    }

     */

    public GameLogic createGame(ServiceManager sm, GameParams gameParams) {

        GameFactoryFunction factory = gameRegistry.get(gameParams.getMode());
        if (factory == null) {
            throw new IllegalArgumentException("Gioco non registrato: " + gameParams.getMode());
        }

        return factory.create(sm, gameParams);
    }
}
