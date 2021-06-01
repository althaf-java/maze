package co.uk.maze.explorer.direction;

import co.uk.maze.explorer.model.ExplorerDirection;
import co.uk.maze.explorer.model.ExplorerMoveType;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Not mocked for now
 * Some tests here covered the tests of ExplorerDirectionFactoryTest should be moved later, time constraint
 */
public class ExplorerDirectionServiceTest {

    private ExplorerDirectionService explorerDirectionService = new ExplorerDirectionService();

    @Test
    public void testFindDirectionWhenHeadingTowardsNorthAndTurnRight() {
        Assert.assertEquals(ExplorerDirection.EAST, explorerDirectionService.findDirection(ExplorerDirection.NORTH, ExplorerMoveType.RIGHT));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsNorthAndTurnLeft() {
        Assert.assertEquals(ExplorerDirection.WEST, explorerDirectionService.findDirection(ExplorerDirection.NORTH, ExplorerMoveType.LEFT));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsSouthAndTurnRight() {
        Assert.assertEquals(ExplorerDirection.WEST, explorerDirectionService.findDirection(ExplorerDirection.SOUTH, ExplorerMoveType.RIGHT));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsSouthAndTurnLeft() {
        Assert.assertEquals(ExplorerDirection.EAST, explorerDirectionService.findDirection(ExplorerDirection.SOUTH, ExplorerMoveType.LEFT));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsEastAndTurnRight() {
        Assert.assertEquals(ExplorerDirection.SOUTH, explorerDirectionService.findDirection(ExplorerDirection.EAST, ExplorerMoveType.RIGHT));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsEastAndTurnLeft() {
        Assert.assertEquals(ExplorerDirection.NORTH, explorerDirectionService.findDirection(ExplorerDirection.EAST, ExplorerMoveType.LEFT));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsWestAndTurnRight() {
        Assert.assertEquals(ExplorerDirection.NORTH, explorerDirectionService.findDirection(ExplorerDirection.WEST, ExplorerMoveType.RIGHT));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsWestAndTurnLeft() {
        Assert.assertEquals(ExplorerDirection.SOUTH, explorerDirectionService.findDirection(ExplorerDirection.WEST, ExplorerMoveType.LEFT));
    }


}
