package uk.gov.dwp.maze.explorer.direction;

import org.springframework.stereotype.Component;
import uk.gov.dwp.maze.explorer.model.ExplorerDirection;
import uk.gov.dwp.maze.explorer.model.ExplorerMoveType;


@Component
public class ExplorerDirectionService {

    public ExplorerDirection findDirection(ExplorerDirection explorerCurrentDirection, ExplorerMoveType explorerMoveType) {
        if (explorerMoveType == ExplorerMoveType.LEFT) {
            return ExplorerDirectionFactory.getLeftOf(explorerCurrentDirection);
        }
        return ExplorerDirectionFactory.getRightOf(explorerCurrentDirection);
    }
}
