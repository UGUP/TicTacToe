package main.java.TicTacToe.model;

public class Cell {

    private int row;
    private int col;

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    private Player player;
    private CellState cellState;

    public CellState getCellState() {
        return cellState;
    }

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState=CellState.EMPTY;
    }

    public void display(){
        if(player==null){
            System.out.print("|-|");
        }else{
            System.out.print("|"+player.getSymbol().getCharacter()+"|");
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
