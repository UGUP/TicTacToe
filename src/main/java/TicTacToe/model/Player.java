package main.java.TicTacToe.model;

import main.java.TicTacToe.controller.TicTacToeController;
import main.java.TicTacToe.strategy.WinningStrategy;

import java.util.List;

public class Player {

    private String name;
    private Symbol symbol;
    protected PlayerType playerType;

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
        this.playerType=PlayerType.HUMAN;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
         return " Name: "+name+" PlayerType:"+playerType;
    }

    public Move makeMove(TicTacToe ticTacToe, Player player, int row, int col){
        return  new Move(player,new Cell(row,col));
    }
}
