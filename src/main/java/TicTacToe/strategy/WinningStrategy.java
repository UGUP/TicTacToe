package main.java.TicTacToe.strategy;

import main.java.TicTacToe.model.Board;
import main.java.TicTacToe.model.Cell;
import main.java.TicTacToe.model.Move;


public interface WinningStrategy {
    public boolean checkWinner(Move move, Board board);
    public void remove(Cell cell,Board board);
}
