package main.java.TicTacToe.strategy;

import main.java.TicTacToe.model.Board;
import main.java.TicTacToe.model.Cell;
import main.java.TicTacToe.model.Move;

import java.sql.SQLOutput;
import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{

   HashMap<Character,Integer> leftDiagonal= new HashMap<>();
   HashMap<Character,Integer> rightDiagonal= new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
       int row= move.getCell().getRow();
       int col=move.getCell().getCol();
       char symbol= move.getCell().getPlayer().getSymbol().getCharacter();

       if(row==col){
           if(!leftDiagonal.containsKey(symbol)){
               leftDiagonal.put(symbol,0);
           }
           leftDiagonal.put(symbol,leftDiagonal.get(symbol)+1);
       }

       if(row+col==board.getDimension()-1){
           if(!rightDiagonal.containsKey(symbol)){
               rightDiagonal.put(symbol,0);
           }
           rightDiagonal.put(symbol,rightDiagonal.get(symbol)+1);
       }

       if(row==col && leftDiagonal.get(symbol)==board.getDimension()){
           return true;
       }

       if(row+col==board.getDimension()-1 && rightDiagonal.get(symbol)==board.getDimension()){
           return true;
       }
       return false;

    }

    @Override
    public void remove(Cell cell,Board board) {
        int row= cell.getRow();
        int col= cell.getCol();
        char currentChar= cell.getPlayer().getSymbol().getCharacter();
        if(row==col){
            leftDiagonal.put(currentChar,leftDiagonal.get(currentChar)-1);
        }

        if(row+col==board.getDimension()-1){
            rightDiagonal.put(currentChar,rightDiagonal.get(currentChar)-1);
        }

    }

}
