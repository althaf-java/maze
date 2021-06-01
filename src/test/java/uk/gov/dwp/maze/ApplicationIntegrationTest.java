package uk.gov.dwp.maze;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import uk.gov.dwp.maze.explorer.Explorer;
import uk.gov.dwp.maze.explorer.model.ExplorerMoveType;
import uk.gov.dwp.maze.model.Cell;
import uk.gov.dwp.maze.model.CellState;
import uk.gov.dwp.maze.util.MazeUtilException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class ApplicationIntegrationTest {

    @Autowired
    private Maze maze;

    @Autowired
    private Explorer explorer;

    //Start of Acceptance Criteria 1
    @Test
    public void testCreateMazeVerifyWallsEmptySpacesExit() throws MazeUtilException, IOException {

        assertEquals(4, maze.getNoOfEmptySpaces());
        assertEquals(1, maze.getNoOfExits());
        assertEquals(14, maze.getNoOfWalls());
    }

    @Test
    public void testGetStatusOfACellByCoordinate() throws MazeUtilException, IOException {

        assertEquals(Character.valueOf('E'), maze.getStatusOfACellByCoordinate(4,1));
    }

    @Test
    public void testCreateMazeForAnUserAndSuccessfullyAbleToShowToUserInReadableFormat() throws MazeUtilException, IOException {
        String fileName = "src//test//resources//Maze-test.txt";
        String stringReturned = maze.toStringReadableFormat();

        assertEquals(Files.lines(Paths.get(fileName), StandardCharsets.US_ASCII).collect(Collectors.joining("\n")), stringReturned.trim());
    }

    //Star of Acceptance Criteria 2
    @Test
    public void testOnBoardExplorerIntoMazeAndVerifyStartLocation() throws MazeUtilException, IOException {

        assertEquals(new Cell(2,1, 'S'), explorer.getCurrentCell());
    }

    @Test
    public void testExplorerAbleToMoveForward() throws MazeUtilException, IOException {

        explorer.move(ExplorerMoveType.FORWARD);
        assertEquals(new Cell(1,1, ' '), explorer.getCurrentCell());
    }

    @Test
    public void testExplorerNotAbleToMoveForwardWhenReachedWall() throws MazeUtilException, IOException {
        Cell expectedCell = new Cell(1,1, ' ');

        explorer.move(ExplorerMoveType.FORWARD);
        assertEquals(expectedCell, explorer.getCurrentCell());
        explorer.move(ExplorerMoveType.FORWARD);
        assertEquals(expectedCell, explorer.getCurrentCell());
    }

    @Test
    public void testExplorerAbleToMoveRight() throws MazeUtilException, IOException {
        explorer.move(ExplorerMoveType.RIGHT);
        assertEquals(new Cell(2,2, ' '), explorer.getCurrentCell());
    }

    @Test
    public void testExplorerNotAbleToMoveRightWhenReachedWall() throws MazeUtilException, IOException {
        Cell expectedCell = new Cell(1,1, ' ');

        explorer.move(ExplorerMoveType.FORWARD);
        explorer.move(ExplorerMoveType.RIGHT);
        assertEquals(expectedCell, explorer.getCurrentCell());
        explorer.move(ExplorerMoveType.RIGHT);
        assertEquals(expectedCell, explorer.getCurrentCell());
    }

    @Test
    public void testExplorerAbleToMoveLeft() throws MazeUtilException, IOException {
        explorer.move(ExplorerMoveType.LEFT);
        assertEquals(new Cell(2,1, 'S'), explorer.getCurrentCell());
    }

    @Test
    public void testExplorerNotAbleToMoveLeftWhenReachedWall() throws MazeUtilException, IOException {
        Cell expectedCell = new Cell(2, 1, 'S');

        explorer.move(ExplorerMoveType.LEFT);
        assertEquals(expectedCell, explorer.getCurrentCell());
        explorer.move(ExplorerMoveType.LEFT);
        assertEquals(expectedCell, explorer.getCurrentCell());
    }


    @Test
    public void testFindWhatIsInFront() throws MazeUtilException, IOException {
        CellState cellState = explorer.findWhatIsInFront();
        assertEquals(CellState.OPEN, cellState);
    }

    @Test
    public void testGetAvailableMovementsFromMyCurrentCell() throws MazeUtilException, IOException {
        List<ExplorerMoveType> availableMovements = explorer.getAvailableMovementsFromCurrentCell();

        List<ExplorerMoveType> lstExplorerMoveType = new ArrayList<>();
        lstExplorerMoveType.add(ExplorerMoveType.RIGHT);
        lstExplorerMoveType.add(ExplorerMoveType.FORWARD);
        assertEquals(lstExplorerMoveType, availableMovements);
    }

    @Test
    public void testExpectedTimesOfUserMovedForwarded() throws MazeUtilException, IOException {
        explorer.move(ExplorerMoveType.FORWARD);
        int expectedTimesOfUserMovedForwarded = explorer.getNoOfTimesMovedForward();
        assertEquals(expectedTimesOfUserMovedForwarded, 1);
    }


    @Test
    public void testAfterUserMovedVerifyCurrentPositionInReadableFormat() throws MazeUtilException, IOException {
        String fileName = "src//test//resources//Maze-test.txt";

        explorer.move(ExplorerMoveType.FORWARD);
        String stringReturned = explorer.toStringReadableFormat();
        assertEquals(Files.lines(Paths.get("src//test//resources//Maze-test-expected-output-after-usermove.txt"),
                StandardCharsets.US_ASCII).collect(Collectors.joining("\n")), stringReturned.trim());
    }

}
