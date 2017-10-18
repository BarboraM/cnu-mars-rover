package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

class InputConverterTest extends Specification {

    @Unroll
    "should return position based on input"() {
        given:
        def input = "1,0"

        when:
        def position = InputConverter.getPositionFromInput(input)

        then:
        position.getX() == 1
        position.getY() == 0
    }

    @Unroll
    "should return #direction based on #input"(String input, Direction direction) {
        expect:
        direction == InputConverter.getDirectionFromInput(input)

        where:
        input | direction
        "N"   | Direction.NORTH
        "E"   | Direction.EAST
        "S"   | Direction.SOUTH
        "W"   | Direction.WEST
    }

    @Unroll
    "should return field based on input size"() {
        given:
        def input = "3"

        when:
        def field = InputConverter.getFieldFromInput(input)

        then:
        field.length == 3
    }

    @Unroll
    "should return landscape with size based on input"() {
        given:
        def input = ".0.\n" +
                "..0\n" +
                ".0."
        def size = 3
        def field = new Field[size][size]
        def testLandscape = new Landscape(MarsTest.testLandscapeInaccessible)
        when:
        def landscape = InputConverter.getLandscapeFromInput(input, size, field)

        then:
        landscape.toString().equals(testLandscape.toString())
    }
}
