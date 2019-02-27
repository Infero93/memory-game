package pl.techplayground.model;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.techplayground.util.ImageLoader;

import java.util.Objects;

import static pl.techplayground.Configuration.MAX_TILE_HEIGHT;
import static pl.techplayground.Configuration.MAX_TILE_WIDTH;

public class MemoryTile extends Button {
    private static final String EMPTY_STRING = "";

    private final ImageView imageView;
    private final Image image;
    private final Integer imageIndex;

    public MemoryTile(Image image, ImageView imageView, Integer imageIndex) {
        super(EMPTY_STRING, imageView);

        this.image = image;
        this.imageView = imageView;
        this.imageIndex = imageIndex;

        toggleDefaultImage();

        setWidth(MAX_TILE_HEIGHT);
        setHeight(MAX_TILE_WIDTH);
    }

    public void toggleDefaultImage() {
        imageView.setImage(ImageLoader.getDefaultImage());
    }

    public void toggleOriginalImage() {
        imageView.setImage(image);
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
