package dk.cngroup.university;

import java.util.ArrayList;

public class Camera {

    ArrayList<Photo> photos;

    public Camera() {
        photos = new ArrayList<>();
    }

    public void takePhoto(RoverPosition position) {
        Photo photoToAdd = new Photo(position.getX(), position.getY());
        if (!photos.contains(photoToAdd)) {
            photos.add(photoToAdd);
        }
    }

    public void printAllPhotos() {
        System.out.println("Following coordinates contained stones:");
        for (Photo photo : photos) {
            System.out.println(photo.toString());
        }
    }
}
