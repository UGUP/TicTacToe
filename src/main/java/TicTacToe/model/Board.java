package main.java.TicTacToe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    private List<List<Cell>> board;
    private int dimension;

    public Board(int dimension) {
        this.dimension=dimension;
        board= new ArrayList<>();
        for(int i=0;i<dimension;i++){
            ArrayList<Cell> row= new ArrayList<>();
            for(int j=0;j<dimension;j++){
                row.add(new Cell(i,j));
            }
            board.add(row);
        }
    }

    public void printBoard() {
        for (List<Cell> row : board) {
            for (Cell cell : row) {
                cell.display();
            }
            System.out.print("\n");
        }
    }


    public int getDimension() {
        return dimension;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }



}
