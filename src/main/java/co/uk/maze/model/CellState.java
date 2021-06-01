package co.uk.maze.model;

import java.util.Arrays;

public enum CellState {
    WALL('X'),
    OPEN(' '),
    START('S'),
    EXIT('E');

    private Character symbol;

    CellState(Character symbol) {
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }

    public static CellState getCellState(Character symbol) {
        return Arrays.stream(CellState.values()).filter((state) -> state.getSymbol() == symbol).findFirst().get();
    }
}
