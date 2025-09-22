package com.g2.game.GameFactory;

import com.g2.game.GameFactory.params.GameParams;
import com.g2.game.GameFactory.params.PartitaSingolaParams;
import com.g2.game.GameModes.GameLogic;
import com.g2.game.GameModes.PartitaSingola;
import com.g2.interfaces.ServiceManager;
import org.springframework.stereotype.Component;

@Component("PartitaSingola")
public class PartitaSingolaFactory implements GameFactoryFunction {
    /*
    @Override
    public GameLogic create(ServiceManager sm, String playerId, String underTestClassName,
                            String type_robot, String difficulty, String mode) {
        return new PartitaSingola(sm, playerId, underTestClassName, type_robot, difficulty, mode);
    }

     */

    @Override
    public GameLogic create(ServiceManager serviceManager, GameParams params) {
        if (!(params instanceof PartitaSingolaParams))
            throw new IllegalArgumentException("Impossibile creare PartitaSingola, params non è del tipo atteso");
        return new PartitaSingola(serviceManager, params.getPlayerId(), params.getUnderTestClassName(), params.getType_robot(),
                params.getDifficulty(), params.getMode(), params.getTestingClassCode(), ((PartitaSingolaParams) params).getRemainingTime());
    }
}
