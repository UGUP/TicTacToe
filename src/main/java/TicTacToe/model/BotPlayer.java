package main.java.TicTacToe.model;

import main.java.TicTacToe.factories.BotPlayingStrategyFactory;
import main.java.TicTacToe.strategy.BotPlayingStrategy;
import main.java.TicTacToe.strategy.EasyBotplayingStrategy;

public class BotPlayer extends Player{

    private DifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;


    public BotPlayer(String name, Symbol symbol,DifficultyLevel difficultyLevel) {
        super(name, symbol);
        this.difficultyLevel=difficultyLevel;
        this.botPlayingStrategy=BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);
        this.playerType=PlayerType.BOT;
    }

    @Override
    public Move makeMove(TicTacToe ticTacToe,Player player,  int row, int col){
       return botPlayingStrategy.makeMove(ticTacToe,player,row,col);
    }

}
