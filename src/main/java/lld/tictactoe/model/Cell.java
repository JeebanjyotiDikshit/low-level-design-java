package lld.tictactoe.model;

import lld.tictactoe.enums.SymbolType;
import lld.tictactoe.exception.CellAlreadyOccupiedException;

public class Cell {

    private SymbolType symbolType;

    boolean isEmpty() {
        return symbolType == null;
    }

    SymbolType getSymbolType() {
        return symbolType;
    }

    void placeSymbol(SymbolType symbolType) {
        if (!isEmpty()) {
            throw new CellAlreadyOccupiedException("Cell is already occupied!");
        }
        this.symbolType = symbolType;
    }

}
