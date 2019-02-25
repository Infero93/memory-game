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
            if(firstTile.getImageView().getImage().equals(secondTile.getImageView().getImage())) {
                firstTile = null;
                secondTile = null;
                score++;
                System.out.println("NOT Error!");
            } else {
                System.out.println("Error!");
            }
        }
    }
}