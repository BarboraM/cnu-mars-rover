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
    "should execute commands, the position should be equal to final position"() {
        given:

        def landscape = new Landscape(LandscapeTest.testLandscapeAccessible)
        def position = new RoverPosition(1, 1)
        def finalPosition = new RoverPosition(0, 0)
        def rover = new Rover()
        def mars = new Mars(rover, landscape, position)

        def simulator = new Simulator(rover, position, finalPosition, landscape, mars, "FRBRFLLF")

        when:
        simulator.executeCommands()

        then:
        mars.getPosition().getX() == finalPosition.getX();
        mars.getPosition().getY() == finalPosition.getY();
    }

    @Unroll
    "should print photos of 2 stones"() {
        def landscape = new Landscape(MarsTest.testLandscapeInaccessible)
        def position = new RoverPosition(2, 0)
        def finalPosition = new RoverPosition(1, 1)
        def rover = new Rover(Direction.EAST)
        def mars = new Mars(rover, landscape, position)

        def simulator = new Simulator(rover, position, finalPosition, landscape, mars, "LFRFRF")

        when:
        simulator.executeCommands()
        def size = mars.getCamera().photos.size()
        def first = mars.getCamera().photos[0]
        def second = mars.getCamera().photos[1]

        then:
        size == 2
        first.toString().equals("2,1")
        second.toString().equals("1,2")

    }
}
