package lld.tictactoe.controller;

import lld.tictactoe.enums.GameStatus;
import lld.tictactoe.enums.SymbolType;
import lld.tictactoe.exception.CellAlreadyOccupiedException;
import lld.tictactoe.model.Board;
import lld.tictactoe.model.Game;
import lld.tictactoe.model.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {
    private final Game game;
    private final Scanner sc;

    public GameController(Game game) {
        this.game = game;
        this.sc = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Game Starts");

        while(game.getGameStatus() == GameStatus.IN_PROGRESS) {
            //printing board
            printBoardState();

            //getting input
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println(currentPlayer.getName() + "'s turn");

            try {
                System.out.print("Enter row: ");
                int row = sc.nextInt();

                System.out.print("Enter column: ");
                int col = sc.nextInt();

                game.makeMove(row, col);
            }
            catch (InputMismatchException e) {
                System.out.println("row and column should be integer");
                sc.nextLine();   // consume invalid input
            }
            catch (IllegalArgumentException | CellAlreadyOccupiedException e) {
                System.out.println(e.getMessage());
            }

        }

        //final board state
        printBoardState();

        if (game.getGameStatus() == GameStatus.WIN) {
            System.out.println(game.getCurrentPlayer().getName() + " has won the game!!! Congrats!!!");
        }
        else if (game.getGameStatus() == GameStatus.DRAW) {
            System.out.println("Game is Draw!!!");
        }

        System.out.println("Game Over!!!");
    }

    private void printBoardState() {
        Board board = game.getBoard();
        int size = board.getSize();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                SymbolType curSymbolType = board.getSymbolType(i, j);
                if (curSymbolType == null) {
                    System.out.print("_ ");
                }
                else{
                    System.out.print(curSymbolType + " ");
                }
            }
            System.out.println();
        }
    }
}
