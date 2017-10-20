package dk.cngroup.university;

public class RoverPosition {
    private int x;
    private int y;

    public RoverPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isInsideLandscape(int landscapeWidth) {
        if (this.getX() < 0
                || this.getY() < 0) {
            return false;
        }

        if (this.getX() >= landscapeWidth) {
            return false;
        }
        if (this.getY() >= landscapeWidth) {
            return false;
        }

        return true;
    }

    @Override
    public boolean equals(Object obj) {
        RoverPosition other = (RoverPosition) obj;
        return (x == other.getX()) && (y == other.getY());
    }
}
