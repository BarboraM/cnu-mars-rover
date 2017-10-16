package dk.cngroup.university;

public class Simulator {
    private Rover rover;
    private RoverPosition startPosition, finalPosition;
    private Landscape landscape;
    private Mars mars;
    private String input;

    public Simulator(String input) {
        this.input = input;
    }

    public void initializeData() {
        String[] position = input.split(",");
        this.startPosition = new RoverPosition(Integer.parseInt(position[0]), Integer.parseInt(position[1]));
    }
}

