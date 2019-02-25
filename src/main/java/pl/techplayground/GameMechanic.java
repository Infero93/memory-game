package pl.techplayground;

import javafx.scene.image.Image;
import pl.techplayground.model.MemoryTile;

public class GameMechanic {
    private static final Integer GRID_WIDTH = 3;
    private static final Integer GRID_HEIGHT = 3;
    private static final Integer IMAGES = 3;

    private MemoryTile[][] tiles;
    private Image[] images;

    public GameMechanic() {
        tiles = new MemoryTile[GRID_WIDTH][GRID_HEIGHT];
        images = new Image[IMAGES];
    }

    public void initializeGrid() {
        getImagesFromResources();

        for(int x = 0; x < GRID_WIDTH; x++) {
            for(int y = 0; y < GRID_HEIGHT; y++) {
                tiles[x][y] = new MemoryTile(null);
            }
        }
    }

    private void getImagesFromResources() {
        images[0] = new Image("/bird.png");
        images[1] = new Image("/dog.png");
        images[2] = new Image("/fish.png");
    }
}
