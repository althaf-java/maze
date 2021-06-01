package uk.gov.dwp.maze.explorer.direction;

import org.junit.Test;
import uk.gov.dwp.maze.explorer.model.ExplorerDirection;
import uk.gov.dwp.maze.explorer.model.ExplorerMoveType;

import static org.junit.Assert.assertEquals;

/**
 * Not mocked for now
 * Some tests here covered the tests of ExplorerDirectionFactoryTest should be moved later, time constraint
 */
public class ExplorerDirectionServiceTest {

    private ExplorerDirectionService explorerDirectionService = new ExplorerDirectionService();

    @Test
    public void testFindDirectionWhenHeadingTowardsNorthAndTurnRight() {
        assertEquals(ExplorerDirection.EAST, explorerDirectionService.findDirection(ExplorerDirection.NORTH, ExplorerMoveType.RIGHT));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsNorthAndTurnLeft() {
        assertEquals(ExplorerDirection.WEST, explorerDirectionService.findDirection(ExplorerDirection.NORTH, ExplorerMoveType.LEFT));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsSouthAndTurnRight() {
        assertEquals(ExplorerDirection.WEST, explorerDirectionService.findDirection(ExplorerDirection.SOUTH, ExplorerMoveType.RIGHT));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsSouthAndTurnLeft() {
        assertEquals(ExplorerDirection.EAST, explorerDirectionService.findDirection(ExplorerDirection.SOUTH, ExplorerMoveType.LEFT));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsEastAndTurnRight() {
        assertEquals(ExplorerDirection.SOUTH, explorerDirectionService.findDirection(ExplorerDirection.EAST, ExplorerMoveType.RIGHT));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsEastAndTurnLeft() {
        assertEquals(ExplorerDirection.NORTH, explorerDirectionService.findDirection(ExplorerDirection.EAST, ExplorerMoveType.LEFT));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsWestAndTurnRight() {
        assertEquals(ExplorerDirection.NORTH, explorerDirectionService.findDirection(ExplorerDirection.WEST, ExplorerMoveType.RIGHT));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsWestAndTurnLeft() {
        assertEquals(ExplorerDirection.SOUTH, explorerDirectionService.findDirection(ExplorerDirection.WEST, ExplorerMoveType.LEFT));
    }


}
