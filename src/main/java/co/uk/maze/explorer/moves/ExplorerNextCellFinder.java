package co.uk.maze.explorer.moves;

import co.uk.maze.Maze;
import co.uk.maze.explorer.model.ExplorerDirection;
import co.uk.maze.explorer.model.ExplorerMoveType;
import co.uk.maze.explorer.moves.strategy.ExplorerNextCellFinderStrategy;
import co.uk.maze.model.Cell;
import org.springframework.stereotype.Component;

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
