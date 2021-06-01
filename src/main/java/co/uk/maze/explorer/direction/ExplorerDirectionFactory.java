package co.uk.maze.explorer.direction;

import co.uk.maze.explorer.model.ExplorerDirection;

import java.util.Arrays;

public enum ExplorerDirectionFactory {

    NORTH(ExplorerDirection.NORTH, ExplorerDirection.EAST, ExplorerDirection.WEST),
    SOUTH(ExplorerDirection.SOUTH,ExplorerDirection.WEST, ExplorerDirection.EAST),
    EAST(ExplorerDirection.EAST,ExplorerDirection.SOUTH, ExplorerDirection.NORTH),
    WEST(ExplorerDirection.WEST,ExplorerDirection.NORTH, ExplorerDirection.SOUTH);

    private ExplorerDirection currentDirection;
    private ExplorerDirection right;
    private ExplorerDirection left;

    ExplorerDirectionFactory(ExplorerDirection currentDirection, ExplorerDirection right, ExplorerDirection left){
        this.currentDirection = currentDirection;
        this.right = right;
        this.left = left;
    }

    public static ExplorerDirection getRightOf(ExplorerDirection explorerCurrentDirection) {
        return Arrays.asList(ExplorerDirectionFactory.values()).stream().filter(
                (explorerDirectionFactory) -> explorerDirectionFactory.currentDirection.equals(explorerCurrentDirection))
                .map((explorerDirectionFactory) -> explorerDirectionFactory.right)
                .findFirst().get();
    }

    public static ExplorerDirection getLeftOf(ExplorerDirection explorerCurrentDirection) {
        return Arrays.asList(ExplorerDirectionFactory.values()).stream().filter(
                (explorerDirectionFactory) -> explorerDirectionFactory.currentDirection.equals(explorerCurrentDirection))
                .map((explorerDirectionFactory) -> explorerDirectionFactory.left)
                .findFirst().get();
    }
}
