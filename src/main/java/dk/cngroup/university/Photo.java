package dk.cngroup.university;

public class Photo {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Photo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    @Override
    public boolean equals(Object obj) {
        Photo other = (Photo) obj;
        return (this.getX() == other.getX()) && (this.getY() == other.getY());
    }


}
