package main.java.TicTacToe.factories;

import main.java.TicTacToe.model.DifficultyLevel;
import main.java.TicTacToe.strategy.BotPlayingStrategy;
import main.java.TicTacToe.strategy.EasyBotplayingStrategy;
import main.java.TicTacToe.strategy.HardBotPlayingStrategy;
import main.java.TicTacToe.strategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static  BotPlayingStrategy getBotPlayingStrategy(DifficultyLevel difficultyLevel){
        if(difficultyLevel.equals(DifficultyLevel.EASY)){
            return new EasyBotplayingStrategy();
        }else if(difficultyLevel.equals(DifficultyLevel.MEDIUM)){
            return new MediumBotPlayingStrategy();
        }else {
            return new HardBotPlayingStrategy();
        }
    }
}
