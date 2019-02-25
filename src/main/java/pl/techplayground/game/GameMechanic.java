package pl.techplayground.game;

import javafx.scene.control.Button;
import pl.techplayground.model.MemoryTile;


public class GameMechanic {

    private GameGridGenerator gameGridGenerator;
    private MemoryTile[][] tiles;

    private MemoryTile firstTile;
    private MemoryTile secondTile;
    private Integer score;

    public GameMechanic(GameGridGenerator gameGridGenerator) {
        this.gameGridGenerator = gameGridGenerator;
    }

    public Button[][] startNewGame() {
        tiles = gameGridGenerator.generateGrid();
        score = 0;
        firstTile = null;
        secondTile = null;

        return tiles;
    }

    public void tileClicked(MemoryTile memoryTile) {
        if(firstTile == null) {
            firstTile = memoryTile;
        } else {
            secondTile = memoryTile;
        }

        memoryTile.toggleOriginalImage();
    }

    public void checkState() {
        if(firstTile == null) {
            return;
        } else if(firstTile == secondTile) {
            System.out.println("Clicked same tile!");
        } else if(firstTile.getImageIndex().equals(secondTile.getImageIndex())) {
            System.out.println("Clicked different tile with same image");
        } else {
            System.out.println("Clicked different tile with different image!");
        }

        firstTile = null;
        secondTile = null;
    }
}
