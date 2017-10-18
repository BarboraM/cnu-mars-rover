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
}
