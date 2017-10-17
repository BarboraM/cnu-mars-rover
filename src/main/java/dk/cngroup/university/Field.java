package dk.cngroup.university;

public enum Field {
    ACCESSIBLE("."),
    INACCESSIBLE("0");

    private String printChar;

    Field(String printChar) {
        this.printChar = printChar;
    }

    public static Field getFieldFromChar(char fieldChar) {
        switch (fieldChar) {
            case '.':
                return ACCESSIBLE;
            case '0':
                return INACCESSIBLE;
        }
        //should never happen
        throw new RuntimeException("unkown worldside value");

    }

    @Override
    public String toString() {
        return printChar;
    }
}
