package pl.techplayground;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.techplayground.model.MemoryTile;

import java.util.Random;

public class GameMechanic {
    private static final Integer GRID_WIDTH = 3;
    private static final Integer GRID_HEIGHT = 3;
    private static final Integer IMAGES = 3;

    private Random random;
    private MemoryTile[][] tiles;
    private Image[] images;

    public GameMechanic() {
        random = new Random();
        tiles = new MemoryTile[GRID_WIDTH][GRID_HEIGHT];
        images = new Image[IMAGES];
    }

    public void initializeGrid() {
        getImagesFromResources();

        for(int x = 0; x < GRID_WIDTH; x++) {
            for(int y = 0; y < GRID_HEIGHT; y++) {
                Integer randomImage = random.nextInt(images.length);
                tiles[x][y] = new MemoryTile(new ImageView(images[randomImage]));
            }
        }
    }

    public Button[][] getTilesAsButtons() {
        return tiles;
    }

    private void getImagesFromResources() {
        images[0] = new Image("/bird.png");
        images[1] = new Image("/dog.png");
        images[2] = new Image("/fish.png");
    }
}
