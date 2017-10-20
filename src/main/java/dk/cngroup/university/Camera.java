package dk.cngroup.university;

import java.util.ArrayList;

public class Camera {
    ArrayList<String> photos;

    public Camera() {
        photos = new ArrayList<>();
    }

    public void takePhoto(RoverPosition position) {
        if (!photos.contains(position.toString())) {
            photos.add(position.toString());
        }
    }

    public void printAllPhotos() {
        System.out.println("Following coordinates contained stones:");
        for (String photo : photos) {
            System.out.println(photo);
        }
    }
}
