package uk.gov.dwp.maze.explorer.moves;

import org.springframework.stereotype.Component;
import uk.gov.dwp.maze.Maze;
import uk.gov.dwp.maze.explorer.model.ExplorerDirection;
import uk.gov.dwp.maze.explorer.model.ExplorerMoveType;
import uk.gov.dwp.maze.explorer.moves.strategy.ExplorerNextCellFinderStrategy;
import uk.gov.dwp.maze.model.Cell;

@Component
public class ExplorerNextCellFinder {

    private ExplorerNextCellFinderStrategy explorerNextCellFinderStrategyForForwardMove;
    private ExplorerNextCellFinderStrategy explorerNextCellFinderStrategyForLeftMove;
    private ExplorerNextCellFinderStrategy explorerNextCellFinderStrategyForRightMove;

    public ExplorerNextCellFinder(ExplorerNextCellFinderStrategy explorerNextCellFinderStrategyForForwardMove,
                                  ExplorerNextCellFinderStrategy explorerNextCellFinderStrategyForLeftMove,
                                  ExplorerNextCellFinderStrategy explorerNextCellFinderStrategyForRightMove) {
        this.explorerNextCellFinderStrategyForForwardMove = explorerNextCellFinderStrategyForForwardMove;
        this.explorerNextCellFinderStrategyForLeftMove = explorerNextCellFinderStrategyForLeftMove;
        this.explorerNextCellFinderStrategyForRightMove = explorerNextCellFinderStrategyForRightMove;
    }


    public Cell findNextCell(ExplorerMoveType explorerMoveType, Maze maze, ExplorerDirection currentDirection, Cell currentCell) {
        if(explorerMoveType == ExplorerMoveType.FORWARD) {
            return explorerNextCellFinderStrategyForForwardMove.findNextCell(maze, currentDirection, currentCell);
        } if(explorerMoveType == ExplorerMoveType.LEFT) {
            return explorerNextCellFinderStrategyForLeftMove.findNextCell(maze, currentDirection, currentCell);
        }
        return explorerNextCellFinderStrategyForRightMove.findNextCell(maze, currentDirection, currentCell);
    }
}
