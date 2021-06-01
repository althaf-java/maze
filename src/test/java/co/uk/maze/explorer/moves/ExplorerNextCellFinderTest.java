package co.uk.maze.explorer.moves;

import co.uk.maze.model.Cell;
import org.junit.Before;
import org.junit.Test;
import co.uk.maze.Maze;
import co.uk.maze.explorer.model.ExplorerDirection;
import co.uk.maze.explorer.model.ExplorerMoveType;
import co.uk.maze.explorer.moves.strategy.impl.ExplorerNextCellFinderStrategyForForwardMove;
import co.uk.maze.explorer.moves.strategy.impl.ExplorerNextCellFinderStrategyForLeftMove;
import co.uk.maze.explorer.moves.strategy.impl.ExplorerNextCellFinderStrategyForRightMove;
import co.uk.maze.util.MazeUtilException;

import static org.junit.Assert.assertEquals;

//**NOTE** NO mocks in this test for time constraint
public class ExplorerNextCellFinderTest {

    private Maze maze;

    private ExplorerNextCellFinder explorerNextCellFinder = new ExplorerNextCellFinder(
            new ExplorerNextCellFinderStrategyForForwardMove(),
            new ExplorerNextCellFinderStrategyForLeftMove(),
            new ExplorerNextCellFinderStrategyForRightMove()
            );

    @Before
    public void setup() throws MazeUtilException {
        String fileName = "src//test//resources//Maze-test.txt";
        maze = new Maze(fileName);
    }

    @Test
    public void testNextForwardCell() {
        Cell expectedCell = new Cell(0,1, 'X');
        Cell actualCell = explorerNextCellFinder.findNextCell(ExplorerMoveType.FORWARD, maze, ExplorerDirection.NORTH, new Cell(1,1, ' '));
        assertEquals(expectedCell.getRow(), actualCell.getRow());
        assertEquals(expectedCell.getColumn(), actualCell.getColumn());
    }

    @Test
    public void testNextLeftCell() {
        Cell expectedCell = new Cell(1,0, 'X');
        Cell actualCell = explorerNextCellFinder.findNextCell(ExplorerMoveType.LEFT, maze, ExplorerDirection.NORTH, new Cell(1,1, ' '));
        assertEquals(expectedCell.getRow(), actualCell.getRow());
        assertEquals(expectedCell.getColumn(), actualCell.getColumn());
    }

    @Test
    public void testNextRightCell() {
        Cell expectedCell = new Cell(1,2, 'X');
        Cell actualCell = explorerNextCellFinder.findNextCell(ExplorerMoveType.RIGHT, maze, ExplorerDirection.NORTH, new Cell(1,1, ' '));
        assertEquals(expectedCell.getRow(), actualCell.getRow());
        assertEquals(expectedCell.getColumn(), actualCell.getColumn());
    }
}
