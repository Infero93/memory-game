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
