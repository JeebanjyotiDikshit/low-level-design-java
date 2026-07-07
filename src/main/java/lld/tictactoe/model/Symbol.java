package lld.tictactoe.model;

import lld.tictactoe.enums.SymbolType;

public abstract class Symbol {
    public SymbolType symbolType;

    Symbol(SymbolType symbolType) {
        this.symbolType = symbolType;
    }
}
