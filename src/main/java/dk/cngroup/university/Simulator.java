package dk.cngroup.university;

public class Simulator {

    public Simulator(Rover rover,
                     RoverPosition startPosition,
                     RoverPosition finalPosition,
                     Landscape landscape,
                     Mars mars,
                     String commands) {
        this.rover = rover;
        this.startPosition = startPosition;
        this.finalPosition = finalPosition;
        this.landscape = landscape;
        this.mars = mars;
        this.commands = commands;
    }

    private Rover rover;
    private RoverPosition startPosition, finalPosition;
    private Landscape landscape;
    private Mars mars;
    private String input;
    private String commands;

    public Simulator(String input) {
        this.input = input;
    }


    public Mars getMars() {
        return mars;
    }

    public void initializeData() {
        String[] lines = input.split("\n");

        startPosition = InputConverter.getPositionFromInput(lines[0]);

        Direction direction = InputConverter.getDirectionFromInput(lines[2]);
        rover = new Rover(direction);

        int sizeOfLandscape = Integer.parseInt(lines[4]);
        Field[][] field = new Field[sizeOfLandscape][sizeOfLandscape];
        String landscapeString = "";
        for (int i = 0; i < sizeOfLandscape; i++) {
            landscapeString += lines[6 + i] + "\n";
        }
        landscape = InputConverter.getLandscapeFromInput(landscapeString, sizeOfLandscape, field);

        mars = new Mars(rover, landscape, startPosition);

        finalPosition = InputConverter.getPositionFromInput(lines[7 + sizeOfLandscape]);

        commands = lines[9 + sizeOfLandscape];
    }

    public boolean runSimulation() {
        Rover newRover;
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            switch (command) {
                case 'F':
                    mars.moveForward();
                    break;
                case 'B':
                    mars.moveBackward();
                    break;
                case 'L':
                    newRover = mars.getRover().turnLeft();
                    mars.setRover(newRover);
                    break;
                case 'R':
                    newRover = mars.getRover().turnRight();
                    mars.setRover(newRover);
                    break;
            }
        }
        boolean result = false;
        if (finalPosition.getX() == mars.getPosition().getX()) {
            if (finalPosition.getY() == mars.getPosition().getY()) {
                result = true;
            }
        }
        return result;
    }
}


