package co.uk.maze.explorer.moves.strategy;

import co.uk.maze.model.Cell;
import co.uk.maze.Maze;
import co.uk.maze.explorer.model.ExplorerDirection;

public interface ExplorerNextCellFinderStrategy {
    Cell findNextCell(Maze maze, ExplorerDirection currentDirection, Cell currentCell);
}
