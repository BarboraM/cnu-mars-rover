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

    public RoverPosition getPositionFromInput(String positionString) {
        String[] position = positionString.split(",");
        return new RoverPosition(Integer.parseInt(position[0]), Integer.parseInt(position[1]));
    }

    public Direction getDirectionFromInput(String directionString) {
        return Direction.getDirectionFromString(directionString);
    }

    public Field[][] getFieldFromInput(String size) {
        int landscapeSize = Integer.parseInt(size);
        Field[][] field = new Field[landscapeSize][landscapeSize];
        return field;
    }
}

