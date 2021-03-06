package co.uk.maze.explorer.moves.strategy.impl;

import co.uk.maze.Maze;
import co.uk.maze.explorer.model.ExplorerDirection;
import co.uk.maze.model.Cell;
import co.uk.maze.util.MazeUtilException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExplorerNextCellFinderStrategyForLeftMoveTest {

    private Maze maze;
    private ExplorerNextCellFinderStrategyForLeftMove explorerNextCellFinderStrategyForLeftMove = new ExplorerNextCellFinderStrategyForLeftMove();

    @Before
    public void setup() throws MazeUtilException {
        String fileName = "src//test//resources//Maze-test.txt";
        maze = new Maze(fileName);
    }

    @Test
    public void testNextLeftCellWhenCurrentDirectionIsNorth() {
        Cell expectedCell = new Cell(1,0, 'X');
        Cell actualCell = explorerNextCellFinderStrategyForLeftMove.findNextCell(maze, ExplorerDirection.NORTH, new Cell(1,1, ' '));
        assertEquals(expectedCell.getRow(), actualCell.getRow());
        assertEquals(expectedCell.getColumn(), actualCell.getColumn());
    }

    @Test
    public void testNextLeftCellWhenCurrentDirectionIsSouth() {
        Cell expectedCell = new Cell(1,2, 'X');
        Cell actualCell = explorerNextCellFinderStrategyForLeftMove.findNextCell(maze, ExplorerDirection.SOUTH, new Cell(1,1, ' '));
        assertEquals(expectedCell.getRow(), actualCell.getRow());
        assertEquals(expectedCell.getColumn(), actualCell.getColumn());
    }

    @Test
    public void testNextLeftCellWhenCurrentDirectionIsEast() {
        Cell expectedCell = new Cell(0,1, 'X');
        Cell actualCell = explorerNextCellFinderStrategyForLeftMove.findNextCell(maze, ExplorerDirection.EAST, new Cell(1,1, ' '));
        assertEquals(expectedCell.getRow(), actualCell.getRow());
        assertEquals(expectedCell.getColumn(), actualCell.getColumn());
    }

    @Test
    public void testNextLeftCellWhenCurrentDirectionIsWEST() {
        Cell expectedCell = new Cell(2,2, 'X');
        Cell actualCell = explorerNextCellFinderStrategyForLeftMove.findNextCell(maze, ExplorerDirection.WEST, new Cell(1,2, ' '));
        assertEquals(expectedCell.getRow(), actualCell.getRow());
        assertEquals(expectedCell.getColumn(), actualCell.getColumn());
    }
}
