package dk.cngroup.university;

public class Landscape {

    private Field[][] landscape;

    public Landscape(Field[][] landscape) {
        this.landscape = landscape;
    }

    public Landscape(RandomFieldGenerator generator, int squareSize) {
        this.landscape = createLandscape(generator, squareSize);
    }

    private Field[][] createLandscape(RandomFieldGenerator generator, int squareSize) {
        Field[][] landscape = new Field[squareSize][squareSize];
        for (int i = 0; i < squareSize; i++) {
            for (int j = 0; j < squareSize; j++) {
                landscape[i][j] = generator.getRandomField();
            }
        }
        return landscape;
    }

    public Field[][] getLandscape() {
        return landscape;
    }

    public int isFieldAccessible(RoverPosition pos) {
        if (!pos.isInsideLandscape(landscape.length)) {
            return -1;
        }

        Field field = landscape[pos.getX()][pos.getY()];
        if (field == Field.ACCESSIBLE) {
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Field[] row : landscape) {
            for (Field field : row) {
                sb.append(field);
            }
            sb.append("\n");
        }

        return sb.toString();
    }


}