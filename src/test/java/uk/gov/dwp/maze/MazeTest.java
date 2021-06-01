package uk.gov.dwp.maze;

import org.junit.Test;
import uk.gov.dwp.maze.model.Cell;
import uk.gov.dwp.maze.util.MazeUtilException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MazeTest {

    @Test
    public void testMazeInstantiatedSuccessfullyWithProperSize() throws MazeUtilException, IOException {
        String fileName = "src//test//resources//Maze-test.txt";
        Maze maze = new Maze(fileName);
        Cell[][] cells = maze.getCells();

        assertEquals(5, cells.length);
        assertEquals(4, cells[0].length);
        assertEquals(4, cells[1].length);
        assertEquals(4, cells[2].length);
        assertEquals(4, cells[3].length);
        assertEquals(4, cells[4].length);

    }

    @Test
    public void testMazeInstantiatedSuccessfullyWithProperData() throws MazeUtilException, IOException {
        String fileName = "src//test//resources//Maze-test.txt";
        Maze maze = new Maze(fileName);
        Cell[][] cells = maze.getCells();

        assertEquals(new Cell(0,0, 'X'), cells[0][0]);
        assertEquals(new Cell(0,1, 'X'), cells[0][1]);
        assertEquals(new Cell(0,2, 'X'), cells[0][2]);
        assertEquals(new Cell(0,3, 'X'), cells[0][3]);

        assertEquals(new Cell(1,0, 'X'), cells[1][0]);
        assertEquals(new Cell(1,1, ' '), cells[1][1]);
        assertEquals(new Cell(1,2, 'X'), cells[1][2]);
        assertEquals(new Cell(1,3, 'X'), cells[1][3]);

        assertEquals(new Cell(2,0, 'X'), cells[2][0]);
        assertEquals(new Cell(2,1, 'S'), cells[2][1]);
        assertEquals(new Cell(2,2, ' '), cells[2][2]);
        assertEquals(new Cell(2,3, 'X'), cells[2][3]);

        assertEquals(new Cell(3,0, 'X'), cells[3][0]);
        assertEquals(new Cell(3,1, ' '), cells[3][1]);
        assertEquals(new Cell(3,2, ' '), cells[3][2]);
        assertEquals(new Cell(3,3, 'X'), cells[3][3]);

        assertEquals(new Cell(4,0, 'X'), cells[4][0]);
        assertEquals(new Cell(4,1, 'E'), cells[4][1]);
        assertEquals(new Cell(4,2, 'X'), cells[4][2]);
        assertEquals(new Cell(4,3, 'X'), cells[4][3]);

    }

    @Test
    public void testGetStatusOfACellByCoordinate() throws MazeUtilException, IOException {
        String fileName = "src//test//resources//Maze-test.txt";
        Maze maze = new Maze(fileName);

        assertEquals(Character.valueOf('E'), maze.getStatusOfACellByCoordinate(4,1));
    }

    @Test
    public void testGetStartingPosition() throws MazeUtilException {
        String fileName = "src//test//resources//Maze-test.txt";
        Maze maze = new Maze(fileName);

        assertEquals(new Cell(2,1, 'S'), maze.getStartingPosition());
    }

    @Test
    public void testGetNoOfWalls() throws MazeUtilException, IOException {
        String fileName = "src//test//resources//Maze-test.txt";
        Maze maze = new Maze(fileName);
        assertEquals(14, maze.getNoOfWalls());
    }

    @Test
    public void testGetNoOfEmptySpaces() throws MazeUtilException, IOException {
        String fileName = "src//test//resources//Maze-test.txt";
        Maze maze = new Maze(fileName);
        assertEquals(4, maze.getNoOfEmptySpaces());
    }

    @Test
    public void testGetNoOfExits() throws MazeUtilException, IOException {
        String fileName = "src//test//resources//Maze-test.txt";
        Maze maze = new Maze(fileName);
        assertEquals(1, maze.getNoOfExits());
    }

    @Test
    public void testToStringReadableFormat() throws MazeUtilException, IOException {
        String fileName = "src//test//resources//Maze-test.txt";
        Maze maze = new Maze(fileName);
        String stringReturned = maze.toStringReadableFormat();

        assertEquals(Files.lines(Paths.get(fileName), StandardCharsets.US_ASCII).collect(Collectors.joining("\n")), stringReturned.trim());
    }
}
