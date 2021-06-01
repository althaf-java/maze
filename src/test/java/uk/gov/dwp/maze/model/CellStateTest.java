package uk.gov.dwp.maze.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellStateTest {

    @Test
    public void testGetCellStateForWall() {
        assertEquals(CellState.WALL, CellState.getCellState('X'));
    }

    @Test
    public void testGetCellStateForOpen() {
        assertEquals(CellState.OPEN, CellState.getCellState(' '));
    }

    @Test
    public void testGetCellStateForStart() {
        assertEquals(CellState.START, CellState.getCellState('S'));
    }

    @Test
    public void testGetCellStateForExit() {
        assertEquals(CellState.EXIT, CellState.getCellState('E'));
    }
}
