package uk.gov.dwp.maze.model;

import java.util.Objects;

public class Cell {
    private int row;
    private int column;
    private CellState state;

    public Cell(int row, int column, char symbol) {
        this.row = row;
        this.column = column;
        this.state = CellState.getCellState(symbol);
    }

    public Cell(int row, int column, CellState cellState) {
        this.row = row;
        this.column = column;
        this.state = cellState;
    }

    public boolean isOpen() {
        return this.state.getSymbol() != CellState.WALL.getSymbol();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return row == cell.row &&
                column == cell.column &&
                state == cell.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, state);
    }
}
