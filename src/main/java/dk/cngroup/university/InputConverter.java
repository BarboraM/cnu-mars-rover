package dk.cngroup.university;

public class InputConverter {

    public static RoverPosition getPositionFromInput(String positionString) {
        String[] position = positionString.split(",");
        return new RoverPosition(Integer.parseInt(position[0]), Integer.parseInt(position[1]));
    }

    public static Direction getDirectionFromInput(String directionString) {
        return Direction.getDirectionFromString(directionString);
    }

    public static Field[][] getFieldFromInput(String size) {
        int landscapeSize = Integer.parseInt(size);
        Field[][] field = new Field[landscapeSize][landscapeSize];
        return field;
    }

    public static Landscape getLandscapeFromInput(String landscapeString, int sizeOfLandscape, Field[][] field) {
        String[] lines = landscapeString.split("\n");
        for (int i = 0; i < sizeOfLandscape; i++) {
            String fieldLine = lines[i];
            for (int j = 0; j < sizeOfLandscape; j++) {
                field[i][j] = Field.getFieldFromChar(fieldLine.charAt(j));
            }
        }
        return new Landscape(field);
    }
}
