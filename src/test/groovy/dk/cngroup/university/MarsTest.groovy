package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

import static dk.cngroup.university.Direction.*
import static dk.cngroup.university.Field.ACCESSIBLE
import static dk.cngroup.university.Field.INACCESSIBLE

class MarsTest extends Specification {

    def static Field[][] testLandscapeInaccessible = [
            [ACCESSIBLE, INACCESSIBLE, ACCESSIBLE],
            [ACCESSIBLE, ACCESSIBLE, INACCESSIBLE],
            [ACCESSIBLE, INACCESSIBLE, ACCESSIBLE]
    ]

    @Unroll
    "should move forward by one to #direction"(Direction direction, int x, int y) {
        given:
        def rover = Mock(Rover)
        rover.getDirection() >> direction

        def landscape = new Landscape(LandscapeTest.testLandscapeAccessible)
        def position = new RoverPosition(1, 1)

        def mars = new Mars(rover, landscape, position)

        when:
        def newPosition = mars
                .moveForward()

        then:
        x == newPosition
                .getX()

        y == newPosition
                .getY()

        where:
        direction | x | y
        NORTH     | 0 | 1
        SOUTH     | 2 | 1
        EAST      | 1 | 2
        WEST      | 1 | 0
    }

    @Unroll
    "should move backward by one to #direction"(Direction direction, int x, int y) {
        given:
        def rover = Mock(Rover)
        rover.getDirection() >> direction

        def landscape = new Landscape(LandscapeTest.testLandscapeAccessible)
        def position = new RoverPosition(1, 1)

        def mars = new Mars(rover, landscape, position)

        when:
        def newPosition = mars
                .moveForward()

        then:
        x == newPosition
                .getX()

        y == newPosition
                .getY()

        where:
        direction | x | y
        NORTH     | 0 | 1
        SOUTH     | 2 | 1
        EAST      | 1 | 2
        WEST      | 1 | 0
    }

    @Unroll
    "should move forward by one to #direction with obstacles"(Direction direction, int x, int y) {
        given:
        def rover = Mock(Rover)
        rover.getDirection() >> direction

        RandomFieldGenerator generator = Mock(RandomFieldGenerator)
        generator.getRandomField() >>> [INACCESSIBLE, INACCESSIBLE, ACCESSIBLE]

        Landscape landscape = new Landscape(generator, 3)

        def position = new RoverPosition(0, 2)

        def mars = new Mars(rover, landscape, position)

        when:
        def newPosition = mars
                .moveForward()

        then:
        x == newPosition
                .getX()

        y == newPosition
                .getY()

        where:
        direction | x | y
        NORTH     | 0 | 2
        SOUTH     | 1 | 2
        EAST      | 0 | 2
        WEST      | 0 | 2
    }

    @Unroll
    "should move backward by one to #direction with obstacles"(Direction direction, int x, int y) {
        given:
        def rover = Mock(Rover)
        rover.getDirection() >> direction

        RandomFieldGenerator generator = Mock(RandomFieldGenerator)
        generator.getRandomField() >>> [INACCESSIBLE, INACCESSIBLE, ACCESSIBLE]

        Landscape landscape = new Landscape(generator, 3)

        def position = new RoverPosition(0, 2)

        def mars = new Mars(rover, landscape, position)

        when:
        def newPosition = mars
                .moveBackward()

        then:
        x == newPosition
                .getX()

        y == newPosition
                .getY()

        where:
        direction | x | y
        NORTH     | 1 | 2
        SOUTH     | 0 | 2
        EAST      | 0 | 2
        WEST      | 0 | 2
    }

    @Unroll
    "should return #isStoneAhead for #direction, if there is a stone ahead"(boolean isStoneAhead, Direction direction) {
        given:
        def rover = new Rover(direction)
        def position = new RoverPosition(1, 1)
        Landscape landscape = new Landscape(testLandscapeInaccessible)
        def mars = new Mars(rover, landscape, position)

        expect:
        isStoneAhead == mars.checkIfStoneAhead()

        where:
        isStoneAhead | direction
        true         | NORTH
        true         | EAST
        true         | SOUTH
        false        | WEST
    }
}
