package lld.tictactoe.strategy;

import lld.tictactoe.enums.SymbolType;
import lld.tictactoe.model.Board;
import lld.tictactoe.model.Move;

public class KConsecutiveWinningStrategy implements WinningStrategy {
    private final int k;

    public KConsecutiveWinningStrategy(int k) {
        if (k <= 0){
            throw new IllegalArgumentException("k should be positive!");
        }
        this.k = k;
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        int left = countInDirection(board, move, 0, -1);
        int right = countInDirection(board, move, 0, 1);
        int horCount = left + right - 1;
        if (horCount >= k) return true;

        int up = countInDirection(board, move, -1, 0);
        int down = countInDirection(board, move, 1, 0);
        int verCount = up + down - 1;
        if (verCount >= k) return true;

        int upLeft = countInDirection(board, move, -1, -1);
        int downRight = countInDirection(board, move, 1, 1);
        int digCount = upLeft + downRight - 1;
        if (digCount >= k) return true;

        int upRight = countInDirection(board, move, -1, 1);
        int downLeft = countInDirection(board, move, 1, -1);
        int antiDigCount = downLeft + upRight - 1;
        if (antiDigCount >= k) return true;

        return false;
    }

    private int countInDirection(
        Board board,
        Move move,
        int dx,
        int dy
    ) {
        int row = move.getRow(), col = move.getCol();
        SymbolType s = move.getPlayer().getSymbolType();
        int count = 0;
        while(row >= 0 && row < board.getSize() &&
                col >= 0 && col < board.getSize() &&
                board.getSymbolType(row, col) == s) {
            count++;
            row += dx;
            col += dy;
        }
        return count;
    }

}
