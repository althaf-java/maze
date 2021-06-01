package uk.gov.dwp.maze.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.dwp.maze.Maze;
import uk.gov.dwp.maze.util.MazeUtilException;

@Configuration
public class PlayConfig {
    @Bean
    public Maze maze(@Value("${maze.config.file}") String mazeConfigFile) throws MazeUtilException {
        Maze maze = new Maze(mazeConfigFile);
        return maze;
    }
}
