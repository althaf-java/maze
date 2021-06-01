package uk.gov.dwp.maze.client;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import uk.gov.dwp.maze.Maze;
import uk.gov.dwp.maze.explorer.Explorer;
import uk.gov.dwp.maze.explorer.model.ExplorerMoveType;

import java.util.Scanner;
import java.util.logging.Logger;

//NOTE: For now only default profile and test profile. this is added not to loaded in the test profile
@Profile("default")
@Component
public class Play {

    private static final Logger LOGGER = Logger.getLogger("Play");
    public Play(Maze maze, Explorer explorer) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info(maze.toStringReadableFormat());
        LOGGER.info("\n");
        while (true) {
            LOGGER.info("Your available movements are " + explorer.getAvailableMovementsFromCurrentCell());
            LOGGER.info("Enter F for move forward, R for move right, L for move left.....");
            scanner = new Scanner(System.in);
            String moveType = scanner.nextLine();
            explorer.move(ExplorerMoveType.getExplorerMoveType(moveType.charAt(0)));
            LOGGER.info("****Your current position indicated by '*' below****");
            LOGGER.info(explorer.toStringReadableFormat());
            LOGGER.info("\n So for moved forward "+ explorer.getNoOfTimesMovedForward()+ " times" );
        }
    }
}
