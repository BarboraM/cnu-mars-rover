package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

class SimulatorTest extends Specification {


    @Unroll
    "should initialize startPosition based on input"() {
        given:
        def input = "1,0"
        def simulator = new Simulator(input)

        when:
        def startPosition = simulator.getPositionFromInput(input)

        then:
        startPosition.getX() == 1
        startPosition.getY() == 0
    }

    @Unroll
    "should initialize #direction based on #input"(String input, Direction direction) {
        given:
        def simulator = new Simulator(input)

        expect:
        direction == simulator.getDirectionFromInput(input)

        where:
        input | direction
        "N"   | Direction.NORTH
        "E"   | Direction.EAST
        "S"   | Direction.SOUTH
        "W"   | Direction.WEST
    }

    @Unroll
    "should initialize field based on input size"() {
        given:
        def input = "3"
        def simulator = new Simulator(input)

        when:
        def field = simulator.getFieldFromInput(input)

        then:
        field.length == 3
    }

    @Unroll
    "should initialize landscape with size based on input"() {
        given:
        def input = ".0.\n" +
                "..0\n" +
                ".0."
        def size = 3
        def field = new Field[size][size]
        def simulator = new Simulator(input)
        def testLandscape = new Landscape(MarsTest.testLandscapeInaccessible)
        when:
        def landscape = simulator.getLandscapeFromInput(input, size, field)

        then:
        landscape.toString().equals(testLandscape.toString())

    }
}
