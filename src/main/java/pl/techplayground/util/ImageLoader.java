package pl.techplayground.util;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImageLoader {

    private static List<Image> IMAGES;

    public static List<Image> getEmbbemedImages() {

        if(IMAGES == null) {
            IMAGES = new ArrayList<>();

            IMAGES.add(new Image("/bird.png", 64,64, true, false));
            IMAGES.add(new Image("/dog.png",64,64, true, false));
            IMAGES.add(new Image("/fish.png", 64,64, true, false));
        }


        return Collections.unmodifiableList(IMAGES);
    }
}
