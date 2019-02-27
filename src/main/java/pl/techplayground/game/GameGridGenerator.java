package pl.techplayground.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.techplayground.model.MemoryTile;
import pl.techplayground.util.ImageLoader;

import java.util.List;
import java.util.Random;

import static pl.techplayground.Configuration.*;


public class GameGridGenerator {

    private Random random;

    public GameGridGenerator(Random random) {
        this.random = random;
    }

    public MemoryTile[][] generateGrid() {
        if((GRID_WIDTH * GRID_HEIGHT) % GRID_MAX_SAME_IMAGE_COUNT != 0) throw new RuntimeException();

        MemoryTile[][] tiles = new MemoryTile[GRID_WIDTH][GRID_HEIGHT];
        populateGrid(tiles);
        shuffleTiles(tiles);
        return tiles;
    }

    private void populateGrid(MemoryTile[][] tiles) {
        List<Image> images = ImageLoader.getEmbbemedImages();
        int currentIndexOfImage = 0;
        int timesImageUsed = 0;

        for(int x = 0; x < GRID_WIDTH; x++) {
            for(int y = 0; y < GRID_HEIGHT; y++) {
                Image image = images.get(currentIndexOfImage);
                tiles[x][y] = new MemoryTile(image, new ImageView(), currentIndexOfImage);

                timesImageUsed++;

                if(timesImageUsed >= GRID_MAX_SAME_IMAGE_COUNT) {
                    currentIndexOfImage++;
                    timesImageUsed = 0;
                }

                if(currentIndexOfImage > images.size()) {
                    if(GRID_ALLOW_REUSE_IMAGES) {
                        currentIndexOfImage = 0;
                    } else {
                        throw new RuntimeException();
                    }
                }
            }
        }
    }

    private void shuffleTiles(MemoryTile[][] tiles) {
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
}
