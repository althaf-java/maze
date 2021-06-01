package co.uk.maze.client;

import co.uk.maze.Maze;
import co.uk.maze.util.MazeUtilException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayConfig {
    @Bean
    public Maze maze(@Value("${maze.config.file}") String mazeConfigFile) throws MazeUtilException {
        Maze maze = new Maze(mazeConfigFile);
        return maze;
    }
}
