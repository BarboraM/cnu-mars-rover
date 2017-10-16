package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

class SimulatorTest extends Specification {


    @Unroll
    "should initialize #startPosition based on input"() {

        given:
        def input = "1,0"
        def simulator = new Simulator(input)

        when:
        simulator.initializeData()

        then:
        simulator.startPosition.getX() == 1
        simulator.startPosition.getY() == 0
    }
}
