package pl.techplayground;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.techplayground.model.MemoryTile;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameMechanic {
    private static final Integer GRID_WIDTH = 10;
    private static final Integer GRID_HEIGHT = 10;
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
        Integer nextImage = 0;
        Integer imageCount = 0;
        List<Integer> usedIndexes = new LinkedList<>();
        getImagesFromResources();

        for(int x = 0; x < GRID_WIDTH; x++) {
            for(int y = 0; y < GRID_HEIGHT; y++) {
                tiles[x][y] = new MemoryTile(new ImageView(images[nextImage]));
                imageCount++;

                if(imageCount >= 2) {
                    nextImage++;
                    imageCount = 0;
                }

                if(nextImage >= 3) {
                    nextImage = 0;
                }
            }
        }

        for(int i = 0; i < GRID_HEIGHT * GRID_WIDTH; i++) {
            int x1 = random.nextInt(GRID_WIDTH);
            int y1 = random.nextInt(GRID_HEIGHT);
            int x2 = random.nextInt(GRID_WIDTH);
            int y2 = random.nextInt(GRID_HEIGHT);

            MemoryTile memoryTile = tiles[x1][y1];
            tiles[x1][y1] = tiles[x2][y2];
            tiles[x2][y2] = memoryTile;
        }
    }

    public Button[][] getTilesAsButtons() {
        return tiles;
    }

    private void getImagesFromResources() {
        images[0] = new Image("/bird.png", 64,64, true, false);
        images[1] = new Image("/dog.png",64,64, true, false);
        images[2] = new Image("/fish.png", 64,64, true, false);
    }
}
