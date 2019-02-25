package pl.techplayground;

import pl.techplayground.model.MemoryTile;

public class GameMechanic {
    private static final Integer GRID_WIDTH = 3;
    private static final Integer GRID_HEIGHT = 3;

    private MemoryTile[][] tiles;

    public GameMechanic() {
        tiles = new MemoryTile[GRID_WIDTH][GRID_HEIGHT];
    }

    public void initializeGrid() {
        for(int x = 0; x < GRID_WIDTH; x++) {
            for(int y = 0; y < GRID_HEIGHT; y++) {
                tiles[x][y] = new MemoryTile(null);
            }
        }
    }
}
