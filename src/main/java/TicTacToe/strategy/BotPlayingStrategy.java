package main.java.TicTacToe.strategy;

import main.java.TicTacToe.model.*;

import java.security.DigestInputStream;

public interface BotPlayingStrategy {

    public Move makeMove(TicTacToe ticTacToe, Player player, int row, int col);
}
