package uk.gov.dwp.maze.explorer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.gov.dwp.maze.Maze;
import uk.gov.dwp.maze.explorer.direction.ExplorerDirectionService;
import uk.gov.dwp.maze.explorer.direction.ExplorerDirectionFactory;
import uk.gov.dwp.maze.explorer.moves.ExplorerNextCellFinder;
import uk.gov.dwp.maze.model.Cell;
import uk.gov.dwp.maze.model.CellState;
import uk.gov.dwp.maze.explorer.model.ExplorerDirection;
import uk.gov.dwp.maze.explorer.model.ExplorerMoveType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO: Should consider interface implementation later.
 */
@Component
public class Explorer {

    @Autowired
    private ExplorerDirectionService explorerDirectionService;

    @Autowired
    private ExplorerNextCellFinder explorerNextCellFinder;

    private Maze maze;

    private Cell currentCell;

    private int noOfTimesMovedForward;

    private ExplorerDirection currentDirection = ExplorerDirection.NORTH;

    public Explorer(Maze maze) {
        this.maze = maze;
        currentCell = maze.getStartingPosition();
    }

    public void move(ExplorerMoveType nextMove) {
        Cell nextMovementCell = explorerNextCellFinder.findNextCell(nextMove, maze, currentDirection, currentCell);
        if (nextMovementCell.isOpen()) {
            if (nextMove.equals(ExplorerMoveType.FORWARD)) {
                currentCell = nextMovementCell;
                noOfTimesMovedForward++;
            } else {
                currentCell = nextMovementCell;
                findDirection(currentDirection, nextMove);
            }
        }
    }

    private ExplorerDirection findDirection(ExplorerDirection explorerCurrentDirection, ExplorerMoveType explorerMoveType) {
        if (explorerMoveType == ExplorerMoveType.LEFT) {
            return ExplorerDirectionFactory.getLeftOf(explorerCurrentDirection);
        }
        return ExplorerDirectionFactory.getRightOf(explorerCurrentDirection);
    }

    public CellState findWhatIsInFront() {
        Character cellState = maze.getCells()[currentCell.getRow()+1][currentCell.getColumn()].getState().getSymbol();
        return CellState.getCellState(cellState);
    }

    public List<ExplorerMoveType> getAvailableMovementsFromCurrentCell() {
        List<ExplorerMoveType> lstExplorerMoveType = new ArrayList<>();
        if (explorerNextCellFinder.findNextCell(ExplorerMoveType.LEFT, maze, currentDirection, currentCell).isOpen()) {
            lstExplorerMoveType.add(ExplorerMoveType.LEFT);
        }
        if (explorerNextCellFinder.findNextCell(ExplorerMoveType.RIGHT, maze, currentDirection, currentCell).isOpen()) {
            lstExplorerMoveType.add(ExplorerMoveType.RIGHT);
        }
        if (explorerNextCellFinder.findNextCell(ExplorerMoveType.FORWARD, maze, currentDirection, currentCell).isOpen()) {
            lstExplorerMoveType.add(ExplorerMoveType.FORWARD);
        }
        return lstExplorerMoveType;
    }

    public String toStringReadableFormat() {
        return Arrays.asList(maze.getCells()).stream().map(row -> {
                    List <String> text = new ArrayList<>();
                    text.addAll(Arrays.asList(row).stream().map(
                            (column) -> {
                                if (column.equals(currentCell)) {
                                    return "*";
                                }
                                return Character.toString(column.getState().getSymbol());
                            }
                    ).collect(Collectors.toList()));
                    text.add("\n");
                    return text;
                }
        ).flatMap((s) -> s.stream()).reduce((s1, s2) -> s1+ s2).get();
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public int getNoOfTimesMovedForward() {
        return noOfTimesMovedForward;
    }

    public void setExplorerDirectionService(ExplorerDirectionService explorerDirectionService) {
        this.explorerDirectionService = explorerDirectionService;
    }

    public void setExplorerNextCellFinder(ExplorerNextCellFinder explorerNextCellFinder) {
        this.explorerNextCellFinder = explorerNextCellFinder;
    }
}
