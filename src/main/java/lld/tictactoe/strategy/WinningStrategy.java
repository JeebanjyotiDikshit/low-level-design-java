package lld.tictactoe.strategy;

import lld.tictactoe.model.Board;
import lld.tictactoe.model.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
