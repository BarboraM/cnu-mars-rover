package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

class SimulatorTest extends Specification {

    @Unroll
    "should initialize data"() {
        given:
        def input = "1,0\n" +
                "\n" +
                "N\n" +
                "\n" +
                "3\n" +
                "\n" +
                ".0.\n" +
                "..0\n" +
                ".0.\n" +
                "\n" +
                "2,3\n" +
                "\n" +
                "RRFLFRFF"
        def simulator = new Simulator(input)

        when:
        simulator.initializeData()
        def mars = simulator.getMars()

        then:
        mars.getRover().getDirection() == Direction.NORTH
        mars.getPosition().getX() == 1
        mars.getPosition().getY() == 0
        mars.getLandscape().toString().equals(""".0.
..0
.0.
""")
    }

    @Unroll
    "should run simulation and return true"() {
        given:

        def landscape = new Landscape(LandscapeTest.testLandscapeAccessible)
        def position = new RoverPosition(1, 1)
        def finalPosition = new RoverPosition(0, 0)
        def rover = new Rover()
        def mars = new Mars(rover, landscape, position)

        def simulator = new Simulator(rover, position, finalPosition, landscape, mars, "FRBRFLLF")

        when:
        def result = simulator.runSimulation()

        then:
        result == true;

    }

}
