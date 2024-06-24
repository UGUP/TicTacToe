package main.java.TicTacToe.strategy;

import main.java.TicTacToe.model.Board;
import main.java.TicTacToe.model.Cell;
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

    @Override
    public void remove(Cell cell,Board board) {
        int row= cell.getRow();
        if(rowMaps.containsKey(row)){
            char currentChar= cell.getPlayer().getSymbol().getCharacter();
            HashMap<Character,Integer> rowmap= rowMaps.get(row);
            int value= rowmap.get(currentChar)-1;
            if(value==0){
                rowMaps.remove(rowMaps.get(row));
            }else{
                rowmap.put(currentChar,rowmap.get(currentChar)-1);
            }
        }
    }
}
