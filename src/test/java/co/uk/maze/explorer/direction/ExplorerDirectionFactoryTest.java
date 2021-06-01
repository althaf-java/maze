package co.uk.maze.explorer.direction;

import co.uk.maze.explorer.model.ExplorerDirection;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExplorerDirectionFactoryTest {

    @Test
    public void testFindDirectionWhenHeadingTowardsNorthAndTurnRight() {
        Assert.assertEquals(ExplorerDirection.EAST, ExplorerDirectionFactory.getRightOf(ExplorerDirection.NORTH));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsNorthAndTurnLeft() {
        Assert.assertEquals(ExplorerDirection.WEST, ExplorerDirectionFactory.getLeftOf(ExplorerDirection.NORTH));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsSouthAndTurnRight() {
        Assert.assertEquals(ExplorerDirection.WEST, ExplorerDirectionFactory.getRightOf(ExplorerDirection.SOUTH));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsSouthAndTurnLeft() {
        Assert.assertEquals(ExplorerDirection.EAST, ExplorerDirectionFactory.getLeftOf(ExplorerDirection.SOUTH));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsEastAndTurnRight() {
        Assert.assertEquals(ExplorerDirection.SOUTH, ExplorerDirectionFactory.getRightOf(ExplorerDirection.EAST));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsEastAndTurnLeft() {
        Assert.assertEquals(ExplorerDirection.NORTH, ExplorerDirectionFactory.getLeftOf(ExplorerDirection.EAST));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsWestAndTurnRight() {
        Assert.assertEquals(ExplorerDirection.NORTH, ExplorerDirectionFactory.getRightOf(ExplorerDirection.WEST));
    }

    @Test
    public void testFindDirectionWhenHeadingTowardsWestAndTurnLeft() {
        Assert.assertEquals(ExplorerDirection.SOUTH, ExplorerDirectionFactory.getLeftOf(ExplorerDirection.WEST));
    }
}
