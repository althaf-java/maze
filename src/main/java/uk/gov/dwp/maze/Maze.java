package uk.gov.dwp.maze;

import uk.gov.dwp.maze.model.Cell;
import uk.gov.dwp.maze.model.CellState;
import uk.gov.dwp.maze.util.MazeUtil;
import uk.gov.dwp.maze.util.MazeUtilException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Maze {

    private Cell[][] cells;

    public Maze(String fileName) throws MazeUtilException {
        Stream<String> lines = new MazeUtil().loadMaze(fileName);
        List<String> lstLines = lines.collect(Collectors.toList());
        int rows = lstLines.size();
        int columns = Stream.of(lstLines.get(0)).findFirst().get().split("").length;
        Cell[][] cells = new Cell[rows][columns];
        for (int i = 0; i < lstLines.size(); i++) {
            String[] innerArray = lstLines.get(i).split("");
            for (int j = 0; j < innerArray.length; j++ ) {
                cells[i][j] = new Cell(i, j, innerArray[j].charAt(0));
            }
        }
        this.cells = cells;
    }

    public Character getStatusOfACellByCoordinate(int row, int column) {
        return cells[row][column].getState().getSymbol();
    }

    public Cell getStartingPosition() {
        return Arrays.asList(cells).stream()
                        .flatMap(cell -> Arrays.asList(cell).stream())
                        .filter((innerCell) -> innerCell.getState() == CellState.START)
                        .findFirst().get();
    }

    public int getNoOfWalls() {
        return filterByCellState(CellState.WALL);
    }

    public int getNoOfEmptySpaces() {
        return filterByCellState(CellState.OPEN);
    }

    public int getNoOfExits() {
        return filterByCellState(CellState.EXIT);
    }

    private int filterByCellState(CellState cellState) {
        return (int)Arrays.asList(cells).stream()
                .flatMap(cell -> Arrays.asList(cell).stream())
                .filter((innerCell) -> innerCell.getState() == cellState).count();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public String toStringReadableFormat() {
        return Arrays.asList(cells).stream().map(row -> {
                    List <String> text = new ArrayList<>();
                    text.addAll(Arrays.asList(row).stream().map((column) -> Character.toString(column.getState().getSymbol())).collect(Collectors.toList()));
                    text.add("\n");
                    return text;
                }
        ).flatMap((s) -> s.stream()).reduce((s1, s2) -> s1+ s2).get();
    }
}
