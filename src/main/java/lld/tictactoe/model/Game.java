package lld.tictactoe.model;

import lld.tictactoe.enums.GameStatus;
import lld.tictactoe.strategy.KConsecutiveWinningStrategy;
import lld.tictactoe.strategy.WinningStrategy;

import java.util.List;
import java.util.Queue;

public class Game {
    private final Board board;
    private final Queue<Player> players;
    private GameStatus gameStatus;
    private final WinningStrategy winningStrategy;

    public Game(int boardSize, Queue<Player> players, int k) {
        this.board = new Board(boardSize);
        if (players == null || players.size() < 2) {
            throw new IllegalArgumentException("invalid players!");
        }
        this.players = players;
        this.winningStrategy = new KConsecutiveWinningStrategy(k);
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public Player getCurrentPlayer() {
        return players.peek();
    }

    public void makeMove(int row, int col) {
        if (gameStatus != GameStatus.IN_PROGRESS) {
            throw new IllegalStateException("Game has already finished.");
        }
        Move move = new Move(row, col, getCurrentPlayer());
        board.placeSymbol(move);
        if (winningStrategy.checkWinner(board, move)) {
            gameStatus = GameStatus.WIN;
        }
        else if (board.isFilled()) {
            gameStatus = GameStatus.DRAW;
        }
        else {
            nextTurn();
        }
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    private void nextTurn() {
        players.offer(players.poll());
    }

    public Board getBoard() {
        return board;
    }
}
