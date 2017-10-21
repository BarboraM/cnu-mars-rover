package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

import static dk.cngroup.university.Field.ACCESSIBLE
import static dk.cngroup.university.Field.INACCESSIBLE

class LandscapeTest extends Specification {

    def static Field[][] testLandscapeAccessible = [
            [ACCESSIBLE, ACCESSIBLE, ACCESSIBLE],
            [ACCESSIBLE, ACCESSIBLE, ACCESSIBLE],
            [ACCESSIBLE, ACCESSIBLE, ACCESSIBLE]
    ]

    @Unroll
    "should create landscape"() {
        given:
        RandomFieldGenerator generator = Mock(RandomFieldGenerator)
        9 * generator.getRandomField() >> ACCESSIBLE

        Landscape landscape = new Landscape(generator, 3)

        expect:
        landscape.getLandscape() == testLandscapeAccessible

    }


    void "should print to string"() {
        given:
        RandomFieldGenerator generator = Mock(RandomFieldGenerator)
        generator.getRandomField() >>> [INACCESSIBLE, INACCESSIBLE, ACCESSIBLE]

        Landscape landscape = new Landscape(generator, 3)

        when:
        String result = landscape.toString();

        then:
        result == """00.
...
...
"""
    }

    @Unroll
    "should return #isAccessible for #x:#y"(int isAccessible, int x, int y) {
        given:
        RandomFieldGenerator generator = Mock(RandomFieldGenerator)
        generator.getRandomField() >>> [INACCESSIBLE, INACCESSIBLE, ACCESSIBLE]

        Landscape landscape = new Landscape(generator, 3)

        def position = new RoverPosition(x, y)

        expect:
        isAccessible == landscape.isFieldAccessible(position)

        where:
        isAccessible | x  | y
        0            | 0  | 0
        0            | 0  | 1
        1            | 0  | 2
        1            | 1  | 0
        -1           | 3  | 3
        -1           | -1 | -2
    }

}
