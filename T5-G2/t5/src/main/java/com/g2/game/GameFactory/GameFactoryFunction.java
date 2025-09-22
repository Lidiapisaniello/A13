package com.g2.game.GameFactory;
import com.g2.game.GameFactory.params.GameParams;
import com.g2.game.GameModes.GameLogic;
import com.g2.interfaces.ServiceManager;

/*
 * Interfaccia con cui si crea un nuovo gioco di tipo GameLogic
 */
@FunctionalInterface
public interface GameFactoryFunction {
    /*
    GameLogic create(ServiceManager serviceManager,
                     String playerId, String underTestClassName,
                     String type_robot, String difficulty, String mode);

     */

    GameLogic create(ServiceManager serviceManager, GameParams params);
}

