package main.java.TicTacToe.strategy;

import main.java.TicTacToe.model.Board;
import main.java.TicTacToe.model.Move;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy{

    HashMap<Integer,HashMap<Character,Integer>> rowMaps= new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int currentRow= move.getCell().getRow();
        char currentSymbol=move.getCell().getPlayer().getSymbol().getCharacter();
         if(!rowMaps.containsKey(currentRow)){
             rowMaps.put(currentRow,new HashMap<>());
         }

         if(!rowMaps.get(currentRow).containsKey(currentSymbol)){
             rowMaps.get(currentRow).put(currentSymbol,0);

         }
         rowMaps.get(currentRow).put(currentSymbol,rowMaps.get(currentRow).get(currentSymbol)+1);
         return  rowMaps.get(currentRow).get(currentSymbol).equals(board.getDimension());
    }
}
