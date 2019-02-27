package pl.techplayground.util;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static pl.techplayground.Configuration.IMG_MAX_HEIGHT;
import static pl.techplayground.Configuration.IMG_MAX_WIDTH;

public class ImageLoader {
    private static List<Image> IMAGES;
    private static Image DEFAULT_IMAGE;

    public static Image getDefaultImage() {
        if(DEFAULT_IMAGE == null) {
            DEFAULT_IMAGE = getImageFromResourcesFolder("transparent.png", IMG_MAX_WIDTH, IMG_MAX_HEIGHT);
        }

        return DEFAULT_IMAGE;
    }

    public static List<Image> getEmbbemedImages() {

        if(IMAGES == null) {
            IMAGES = new ArrayList<>();
            List<String> filenames = new LinkedList<>();
            filenames.add("bear");
            filenames.add("bird");
            filenames.add("cat");
            filenames.add("cow");
            filenames.add("dog");
            filenames.add("duck");
            filenames.add("fish");
            filenames.add("reindeer");

            for(String filename : filenames) {
                IMAGES.add(getImageFromResourcesFolder(filename + ".png", IMG_MAX_WIDTH, IMG_MAX_HEIGHT));
            }
        }


        return Collections.unmodifiableList(IMAGES);
    }

    private static Image getImageFromResourcesFolder(String filename, int width, int height) {
        return new Image(ImageLoader.class.getResourceAsStream("/images/" + filename), width,height, false, false);
    }
}
