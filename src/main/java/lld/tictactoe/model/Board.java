package lld.tictactoe.model;

import lld.tictactoe.enums.SymbolType;
import lld.tictactoe.exception.CellAlreadyOccupiedException;
import lld.tictactoe.exception.InvalidBoardSizeException;
import lld.tictactoe.exception.InvalidPositionException;

public class Board {

    private final int size;
    private final Cell[][] cells;
    private int filledCells;

    Board(int size) {
        if (size <= 0) {
            throw new InvalidBoardSizeException("Please enter valid positive size!");
        }
        this.size = size;
        cells = new Cell[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
        filledCells = 0;
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    void placeSymbol(Move move) {
        if (!isValidPosition(move.getRow(), move.getCol())) {
            throw new InvalidPositionException("Please enter valid position!");
        }
        Cell cell = cells[move.getRow()][move.getCol()];
        cell.placeSymbol(move.getPlayer().getSymbolType());
        filledCells++;
    }

    boolean isFilled() {
        return filledCells == size * size;
    }

    public SymbolType getSymbolType(int row, int col) {
        if (!isValidPosition(row, col)) {
            throw new InvalidPositionException("Invalid position!");
        }
        Cell cell = cells[row][col];
        return cell.getSymbolType();
    }

}
