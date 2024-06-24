package main.java.TicTacToe.strategy;

import main.java.TicTacToe.model.Board;
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

}
