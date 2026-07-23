package lld.tictactoe;

import lld.tictactoe.controller.GameController;
import lld.tictactoe.enums.SymbolType;
import lld.tictactoe.model.Game;
import lld.tictactoe.model.Player;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static Game createGame() {
        System.out.print("Enter the Board size : ");
        int boardSize = sc.nextInt();
        System.out.print("Enter winning length k : ");
        int k = sc.nextInt();
        sc.nextLine();

        Queue<Player> players = new LinkedList<>();
        System.out.print("Player 1, Enter your name: ");
        String currentPlayerName = sc.nextLine();
        System.out.println(currentPlayerName + ", your unique symbol is X.");
        players.add(new Player(currentPlayerName, SymbolType.X));

        System.out.print("Player 2, Enter your name: ");
        currentPlayerName = sc.nextLine();
        System.out.println(currentPlayerName + ", your unique symbol is O.");
        players.add(new Player(currentPlayerName, SymbolType.O));

        return new Game(boardSize, players, k);
    }

    public static void main(String[] args) {

        System.out.println("Tic Tac Toe Game Started.");

        Game game = createGame();
        GameController gameController = new GameController(game);
        gameController.startGame();

        System.out.println("Game Over!!!");
    }
}