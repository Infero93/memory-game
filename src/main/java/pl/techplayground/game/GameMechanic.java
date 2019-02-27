package pl.techplayground.game;

import javafx.scene.control.Button;
import pl.techplayground.model.MemoryTile;

import static pl.techplayground.Configuration.*;


public class GameMechanic {

    private GameGridGenerator gameGridGenerator;

    private MemoryTile firstTile;
    private MemoryTile secondTile;
    private Integer score;
    private Integer mistakes;
    private Boolean pairFound;

    public GameMechanic(GameGridGenerator gameGridGenerator) {
        this.gameGridGenerator = gameGridGenerator;
        resetGameState();
    }

    public Button[][] startNewGame() {
        resetGameState();
        return gameGridGenerator.generateGrid();
    }

    public void gameLoop(MemoryTile memoryTile) {
        clearTiles();
        tileClicked(memoryTile);
        updateState();
    }

    public boolean hasGameEnded() {
        return score == (GRID_WIDTH * GRID_HEIGHT) / GRID_MAX_SAME_IMAGE_COUNT;
    }

    private void resetGameState() {
        pairFound = false;
        score = 0;
        mistakes = 0;
        firstTile = null;
        secondTile = null;
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

    private void updateState() {
        if(bothTilesSelected()) {
            if(firstTile == secondTile) {
                System.out.println("Clicked same tile!");
            } else if(firstTile.getImageIndex().equals(secondTile.getImageIndex())) {
                System.out.println("Clicked different tile with same image");
                firstTile.setDisable(true);
                secondTile.setDisable(true);
                pairFound = true;
                score += 1;
            } else {
                System.out.println("Clicked different tile with different image!");
                pairFound = false;
                mistakes += 1;
            }
        }
    }


    private boolean bothTilesSelected() {
        return firstTile != null && secondTile != null;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getMistakes() {
        return mistakes;
    }
}
