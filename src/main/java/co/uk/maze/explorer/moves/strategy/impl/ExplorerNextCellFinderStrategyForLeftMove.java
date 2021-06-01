package co.uk.maze.explorer.moves.strategy.impl;

import co.uk.maze.explorer.moves.strategy.ExplorerNextCellFinderStrategy;
import co.uk.maze.model.Cell;
import org.springframework.stereotype.Component;
import co.uk.maze.Maze;
import co.uk.maze.explorer.model.ExplorerDirection;

@Component
public class ExplorerNextCellFinderStrategyForLeftMove  implements ExplorerNextCellFinderStrategy {
    public Cell findNextCell(Maze maze, ExplorerDirection currentDirection, Cell currentCell) {
        if (currentDirection == ExplorerDirection.NORTH) {
            return maze.getCells()[currentCell.getRow()][currentCell.getColumn() - 1];
        }if (currentDirection == ExplorerDirection.SOUTH) {
            return maze.getCells()[currentCell.getRow()][currentCell.getColumn() + 1];
        }if (currentDirection == ExplorerDirection.EAST) {
            return maze.getCells()[currentCell.getRow()-1][currentCell.getColumn()];
        }else {
            return maze.getCells()[currentCell.getRow()+1][currentCell.getColumn()];
        }
    }
}
