package uk.gov.dwp.maze.explorer.direction;

import org.junit.Test;
import uk.gov.dwp.maze.explorer.model.ExplorerDirection;
import uk.gov.dwp.maze.explorer.model.ExplorerMoveType;

import static org.junit.Assert.assertEquals;

public class ExplorerDirectionFactoryTest {

    @Test
    public void testFindDirectionWhenHeadingTowardsNorthAndTurnRight() {
        assertEquals(ExplorerDirection.EAST, ExplorerDirectionFactory.getRightOf(ExplorerDirection.NORTH));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsNorthAndTurnLeft() {
        assertEquals(ExplorerDirection.WEST, ExplorerDirectionFactory.getLeftOf(ExplorerDirection.NORTH));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsSouthAndTurnRight() {
        assertEquals(ExplorerDirection.WEST, ExplorerDirectionFactory.getRightOf(ExplorerDirection.SOUTH));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsSouthAndTurnLeft() {
        assertEquals(ExplorerDirection.EAST, ExplorerDirectionFactory.getLeftOf(ExplorerDirection.SOUTH));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsEastAndTurnRight() {
        assertEquals(ExplorerDirection.SOUTH, ExplorerDirectionFactory.getRightOf(ExplorerDirection.EAST));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsEastAndTurnLeft() {
        assertEquals(ExplorerDirection.NORTH, ExplorerDirectionFactory.getLeftOf(ExplorerDirection.EAST));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsWestAndTurnRight() {
        assertEquals(ExplorerDirection.NORTH, ExplorerDirectionFactory.getRightOf(ExplorerDirection.WEST));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsWestAndTurnLeft() {
        assertEquals(ExplorerDirection.SOUTH, ExplorerDirectionFactory.getLeftOf(ExplorerDirection.WEST));
    }
}
