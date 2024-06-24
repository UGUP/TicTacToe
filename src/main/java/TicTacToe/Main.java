package main.java.TicTacToe;

import main.java.TicTacToe.controller.TicTacToeController;
import main.java.TicTacToe.exceptions.InvalidMoveException;
import main.java.TicTacToe.model.*;
import main.java.TicTacToe.strategy.ColumnWinningStrategy;
import main.java.TicTacToe.strategy.DiagonalWinningStrategy;
import main.java.TicTacToe.strategy.RowWinningStrategy;
import main.java.TicTacToe.strategy.WinningStrategy;

import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InvalidMoveException {
        Scanner sc= new Scanner(System.in);
        System.out.println("-------------Game Started--------------");
        System.out.println("Enter the Dimension of the board");
        int dimension= sc.nextInt();
        List<WinningStrategy> strategy= List.of(new RowWinningStrategy(),new DiagonalWinningStrategy(),new ColumnWinningStrategy());
        DifficultyLevel difficultyLevel= DifficultyLevel.EASY;
        Queue<Player> players= new LinkedList<>();
        players.add(new Player("Upma",new Symbol('X')));
        players.add(new BotPlayer("Deepak",new Symbol('0'),difficultyLevel));

        TicTacToeController controller = new TicTacToeController();
        TicTacToe ticTacToe=controller.startGame(dimension,players,strategy);

        try{
        while(controller.getState().equals(TicTacToeState.INPROGRES)){
            System.out.println("Printing the Board \n");
            controller.printBoard(ticTacToe);
            Player lastPlayer= players.peek();
            System.out.println(" the type of player is "+lastPlayer.getPlayerType());
            players.add(players.poll());
            int row=0;
            int col=0;
            if(lastPlayer.getPlayerType().equals(PlayerType.HUMAN)){
                System.out.println("Enter the row");
                 row= sc.nextInt();
                System.out.println("Enter the column");
                col= sc.nextInt();
            }

            controller.makeMove(ticTacToe,lastPlayer,row,col);
            System.out.println();
            controller.printBoard(ticTacToe);

            if(lastPlayer.getPlayerType().equals(PlayerType.HUMAN)){
                System.out.println("Do you want to undo your move y/n");
                String input= sc.next();
                if(input.equalsIgnoreCase("y")){
                    controller.undo(ticTacToe,row,col);
                    System.out.println(" The board after undo ..................\n ");
                    controller.printBoard(ticTacToe);
                    players.add(players.poll());
                }
            }

            if(controller.getState().equals(TicTacToeState.DRAW)){
                controller.setState(TicTacToeState.DRAW);
                System.out.println("Its a Draw!!!!!!!!!");
            }

            if(controller.getState().equals(TicTacToeState.ENDED)){
                controller.setState(TicTacToeState.ENDED);
                System.out.println("the winner is "+ticTacToe.getWinner());
            }

        }}catch (Exception e){
            System.out.println("please make a valid move");
        }
    }
}
