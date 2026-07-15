package lld.tictactoe.model;

import lld.tictactoe.enums.SymbolType;

public class Player {

    private final String name;
    private final SymbolType symbolType;

    public Player(String name, SymbolType symbolType) {
        this.name = name;
        this.symbolType = symbolType;
    }

    public String getName() {
        return name;
    }

    public SymbolType getSymbolType() {
        return symbolType;
    }

}
