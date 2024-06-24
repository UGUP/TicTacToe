package main.java.TicTacToe.strategy;

import main.java.TicTacToe.model.*;

import java.util.List;

public class EasyBotplayingStrategy implements  BotPlayingStrategy{

    @Override
    public Move makeMove(TicTacToe ticTacToe,Player player,int row,int col) {
        //Iterate over the board and make a move at the first empty cell.
        for (List<Cell> rows : ticTacToe.getBoard().getBoard()) {
            for (Cell cell : rows) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(
                            player,
                            cell
                    );
                }
            }
        }
        return null;
    }
}
