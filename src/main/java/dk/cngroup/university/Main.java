package dk.cngroup.university;

public class Main {

    public static void main(String[] args) {
        String input = "1,0\n" +
                "\n" +
                "N\n" +
                "\n" +
                "5\n" +
                "\n" +
                "..0..\n" +
                ".....\n" +
                ".0..0\n" +
                ".0...\n" +
                ".....\n" +
                "\n" +
                "4,0\n" +
                "\n" +
                "RRFLFRFF";
        Simulator simulator = new Simulator(input);
        boolean result = simulator.runSimulation();
        System.out.println(result);
    }
}
