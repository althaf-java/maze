package uk.gov.dwp.maze.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MazeUtil {

    public Stream<String> loadMaze(String filename) throws MazeUtilException {
        try {
            return Files.lines(Paths.get(filename));
        } catch (IOException e) {
            throw new MazeUtilException(e);
        }
    }
}
