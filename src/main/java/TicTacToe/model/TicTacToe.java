package main.java.TicTacToe.model;

import main.java.TicTacToe.exceptions.InvalidMoveException;
import main.java.TicTacToe.strategy.BotPlayingStrategy;
import main.java.TicTacToe.strategy.WinningStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.RecursiveTask;

public class TicTacToe {
    private Board board;
    private Queue<Player> players;
    private List<Move> moves=new ArrayList<>();
    private List<Symbol>symbols;
    private TicTacToeState ticTacToeState=TicTacToeState.INPROGRES;
    private List<WinningStrategy> winningStrategy;
    private BotPlayingStrategy botPlayingStrategy;

    public String getWinner() {
        return winner;
    }

    private String winner;


    private TicTacToe(BuilderHelpper builderHelpper) {
        this.board = builderHelpper.getBoard();
        this.players = builderHelpper.getPlayers();
        this.winningStrategy =builderHelpper.getWinningStrategy();
    }


    public static BuilderHelpper  getBuilder(){
        return new BuilderHelpper();
    }

    public Board getBoard() {
        return board;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public TicTacToeState getTicTacToeState() {
        return ticTacToeState;
    }

    public List<WinningStrategy> getWinningStrategy() {
        return winningStrategy;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void printBoard(TicTacToe ticTacToe) {
        ticTacToe.getBoard().printBoard();
    }

    public boolean isValid(TicTacToe ticTacToe,int row,int col ){

        Cell cell= new Cell(row,col);
        if(row<0 || row>=ticTacToe.getBoard().getDimension() || col<0 || col>=ticTacToe.getBoard().getDimension() || !cell.getCellState().equals(CellState.EMPTY)){
            return false;
        }else{
            return true;
        }

    }

    public TicTacToeState makeMove(TicTacToe ticTacToe,Player player,int row,int col) throws InvalidMoveException {
        if (!isValid(ticTacToe,row,col)){
            throw new InvalidMoveException("Please make a valid move");
        }else{
            Move move=player.makeMove(ticTacToe,player,row,col);
            Cell cell= board.getBoard().get(move.getCell().getRow()).get(move.getCell().getCol());
            cell.setCellState(CellState.FILLED);
            cell.setPlayer(player);
            Move finalMove= new Move(player,cell);
            moves.add(finalMove);
            System.out.println(player.getName()+ " made a move of "+player.getSymbol().getCharacter());
            if(checkWinner(finalMove)){
                ticTacToeState=TicTacToeState.ENDED;
                winner=player.getName();
            }else if(moves.size()== board.getDimension()* board.getDimension()){
                ticTacToeState= TicTacToeState.DRAW;
            }
        }
        return ticTacToeState;
    }

    public boolean checkWinner(Move move){
        for (WinningStrategy strategy:winningStrategy){
            if(strategy.checkWinner(move,board)){
                return true;
            }
        }
        return false;
    }

    public void undo(int row, int col) {
        //Removing the last from the moves list;
        moves.remove(moves.get(moves.size()-1));

        // Resetting the board ,cell and teh player
        Cell cell = board.getBoard().get(row).get(col);
        undoMoveFromHashMap(cell,board);
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);

    }

    public void undoMoveFromHashMap(Cell cell,Board board){
        for (WinningStrategy strategy:winningStrategy){
            strategy.remove(cell,board);
        }

    }

    public static class BuilderHelpper{
        private int  sizeOfBoard;
        private Queue<Player> players;
        private List<WinningStrategy> winningStrategy;
        private Board board;

        public int getSizeOfBoard() {
            return sizeOfBoard;
        }

        public BuilderHelpper setSizeOfBoard(int sizeOfBoard) {
            this.sizeOfBoard = sizeOfBoard;
            this.board= new Board(sizeOfBoard);
            return this;
        }

        public Board getBoard(){
             return  board;
        }

        public Queue<Player> getPlayers() {
            return players;
        }

        public BuilderHelpper setPlayers(Queue<Player> players) {
            this.players = players;
            return this;
        }


        public List<WinningStrategy> getWinningStrategy() {
            return winningStrategy;
        }

        public BuilderHelpper setWinningStrategy(List<WinningStrategy> winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public TicTacToe build(){
            return new TicTacToe(this);
        }
    }
}
