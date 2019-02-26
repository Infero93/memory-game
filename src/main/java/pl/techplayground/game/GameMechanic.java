package pl.techplayground.game;

import javafx.scene.control.Button;
import pl.techplayground.model.MemoryTile;


public class GameMechanic {

    private GameGridGenerator gameGridGenerator;
    private MemoryTile[][] tiles;

    private MemoryTile firstTile;
    private MemoryTile secondTile;
    private Integer score;
    private Boolean pairFound;

    public GameMechanic(GameGridGenerator gameGridGenerator) {
        this.gameGridGenerator = gameGridGenerator;
    }

    public Button[][] startNewGame() {
        tiles = gameGridGenerator.generateGrid();
        pairFound = false;
        score = 0;
        firstTile = null;
        secondTile = null;

        return tiles;
    }

    public void gameLoop(MemoryTile memoryTile) {
        clearTiles();
        tileClicked(memoryTile);
        checkState();
    }

    private void clearTiles() {
        if(bothTilesSelected()) {
            if(!pairFound) {
                firstTile.toggleDefaultImage();
                secondTile.toggleDefaultImage();
            }

            firstTile = null;
            secondTile = null;
        }
    }

    private void tileClicked(MemoryTile memoryTile) {
        if(firstTile == null) {
            firstTile = memoryTile;
        } else {
            secondTile = memoryTile;
        }

        memoryTile.toggleOriginalImage();
    }

    private void checkState() {
        if(bothTilesSelected()) {
            if(firstTile == secondTile) {
                System.out.println("Clicked same tile!");
            } else if(firstTile.getImageIndex().equals(secondTile.getImageIndex())) {
                System.out.println("Clicked different tile with same image");
                firstTile.setDisable(true);
                secondTile.setDisable(true);
                pairFound = true;
            } else {
                System.out.println("Clicked different tile with different image!");
                pairFound = false;
            }
        }
    }

    private boolean bothTilesSelected() {
        return firstTile != null && secondTile != null;
    }
}
