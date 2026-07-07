package org.example;

public abstract class Symbol {
    public SymbolType symbolType;

    Symbol(SymbolType symbolType) {
        this.symbolType = symbolType;
    }
}
