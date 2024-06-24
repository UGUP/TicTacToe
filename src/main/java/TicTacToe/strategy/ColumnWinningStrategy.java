package main.java.TicTacToe.strategy;

import main.java.TicTacToe.model.Board;
import main.java.TicTacToe.model.Cell;
import main.java.TicTacToe.model.Move;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements  WinningStrategy{

    HashMap<Integer,HashMap<Character,Integer>> colMaps=new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int currentCol= move.getCell().getCol();
        char currentSymbol=move.getCell().getPlayer().getSymbol().getCharacter();
        if(!colMaps.containsKey(currentCol)){
            colMaps.put(currentCol,new HashMap<>());
        }

        Map<Character,Integer> currentColMap= colMaps.get(currentCol);
        if(!currentColMap.containsKey(currentSymbol)){
            currentColMap.put(currentSymbol,0);
        }
        currentColMap.put(currentSymbol,currentColMap.get(currentSymbol)+1);
        return currentColMap.get(currentSymbol).equals(board.getDimension());

    }

    @Override
    public void remove(Cell cell,Board board) {
        int col= cell.getCol();
        if(colMaps.containsKey(col)){
            char currentChar= cell.getPlayer().getSymbol().getCharacter();
            HashMap<Character,Integer> colmap= colMaps.get(col);
            int value= colmap.get(currentChar)-1;
            if(value==0){
                colMaps.remove(colMaps.get(col));
            }else{
                colmap.put(currentChar,colmap.get(currentChar)-1);
            }
        }
    }

}
