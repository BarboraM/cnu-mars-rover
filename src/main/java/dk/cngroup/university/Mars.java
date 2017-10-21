package dk.cngroup.university;

public class Mars {
    private Rover rover;
    private Landscape landscape;
    private RoverPosition position;
    private Camera camera;

    public Mars(Rover rover, Landscape landscape, RoverPosition position) {
        this.rover = rover;
        this.landscape = landscape;
        this.position = position;
        camera = new Camera();
    }

    public RoverPosition getPosition() {
        return position;
    }

    public Rover getRover() {
        return rover;
    }

    public Landscape getLandscape() {
        return landscape;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public RoverPosition moveForward() {
        RoverPosition forwardPosition = RoverPositionFactory.getForwardPosition(position, rover.getDirection());

        if (landscape.isFieldAccessible(forwardPosition)) {
            this.position = forwardPosition;
            return forwardPosition;

        } else {
            return position;
        }
    }

    public RoverPosition moveBackward() {
        RoverPosition backwardPosition = RoverPositionFactory.getBackwardPosition(position, rover.getDirection());

        if (landscape.isFieldAccessible(backwardPosition)) {
            this.position = backwardPosition;
            return backwardPosition;
        } else {
            return position;
        }
    }

    public boolean checkIfStoneAhead() {
        return !landscape.isFieldAccessible(getForwardPosition());
    }

    public RoverPosition getForwardPosition() {
        return RoverPositionFactory.getForwardPosition(position, rover.getDirection());
    }
}
