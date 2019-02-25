package pl.techplayground.model;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.util.Objects;

import static pl.techplayground.Configuration.MAX_TILE_HEIGHT;
import static pl.techplayground.Configuration.MAX_TILE_WIDTH;

public class MemoryTile extends Button {
    private static final String EMPTY_STRING = "";

    private final ImageView imageView;
    private final Integer imageIndex;

    public MemoryTile(ImageView imageView, Integer imageIndex) {
        super(EMPTY_STRING, imageView);

        this.imageIndex = imageIndex;
        this.imageView = imageView;

        setWidth(MAX_TILE_HEIGHT);
        setHeight(MAX_TILE_WIDTH);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Integer getImageIndex() {
        return imageIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemoryTile that = (MemoryTile) o;
        return Objects.equals(imageView, that.imageView) && Objects.equals(imageIndex, that.imageIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageView, imageIndex);
    }
}
