package main.java.TicTacToe.controller;

import main.java.TicTacToe.exceptions.InvalidMoveException;
import main.java.TicTacToe.model.*;
import main.java.TicTacToe.strategy.WinningStrategy;

import java.util.List;
import java.util.Queue;

public class TicTacToeController {

    private TicTacToeState state;
    private List<WinningStrategy> strategy;
    private Board board;
    private Move move;
    private int lastPlayerIndex;


    public TicTacToe startGame(int dimension, Queue<Player> players, List<WinningStrategy> strategy){
        TicTacToe ticTacToe= TicTacToe.getBuilder().
                setSizeOfBoard(dimension).
                setPlayers(players).
                setWinningStrategy(strategy).
                build();
        this.state= TicTacToeState.INPROGRES;
        this.strategy=strategy;
        this.board=TicTacToe.getBuilder().getBoard();
        this.lastPlayerIndex=0;
        return ticTacToe;
    }

    public void setState(TicTacToeState state) {
        this.state = state;
    }

    public TicTacToeState getState() {
        return this.state;
    }

    public List<WinningStrategy> getStrategy() {
        return strategy;
    }

    public Board getBoard() {
        return board;
    }

    public Move getMove() {
        return move;
    }

    public void printBoard(TicTacToe ticTacToe){
        ticTacToe.printBoard(ticTacToe);
    }

    public void makeMove(TicTacToe ticTacToe,Player player,int row,int col) throws InvalidMoveException {
      TicTacToeState ticTacToeState= ticTacToe.makeMove(ticTacToe,player,row,col);
      setState(ticTacToeState);
    }


    public void undo(TicTacToe ticTacToe, int row, int col) {
        System.out.println("Undoing the move.");
        ticTacToe.undo(row,col);

    }
}
