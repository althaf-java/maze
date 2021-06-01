package uk.gov.dwp.maze.explorer.moves.strategy.impl;

import org.springframework.stereotype.Component;
import uk.gov.dwp.maze.Maze;
import uk.gov.dwp.maze.explorer.model.ExplorerDirection;
import uk.gov.dwp.maze.explorer.moves.strategy.ExplorerNextCellFinderStrategy;
import uk.gov.dwp.maze.model.Cell;

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
