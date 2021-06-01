package uk.gov.dwp.maze.explorer.moves.strategy;

import uk.gov.dwp.maze.Maze;
import uk.gov.dwp.maze.explorer.model.ExplorerDirection;
import uk.gov.dwp.maze.model.Cell;

public interface ExplorerNextCellFinderStrategy {
    Cell findNextCell(Maze maze, ExplorerDirection currentDirection, Cell currentCell);
}
