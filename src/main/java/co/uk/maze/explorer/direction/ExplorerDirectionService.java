package co.uk.maze.explorer.direction;

import co.uk.maze.explorer.model.ExplorerDirection;
import co.uk.maze.explorer.model.ExplorerMoveType;
import org.springframework.stereotype.Component;


@Component
public class ExplorerDirectionService {

    public ExplorerDirection findDirection(ExplorerDirection explorerCurrentDirection, ExplorerMoveType explorerMoveType) {
        if (explorerMoveType == ExplorerMoveType.LEFT) {
            return ExplorerDirectionFactory.getLeftOf(explorerCurrentDirection);
        }
        return ExplorerDirectionFactory.getRightOf(explorerCurrentDirection);
    }
}
