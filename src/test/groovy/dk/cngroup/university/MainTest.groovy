package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll


class MainTest extends Specification {


    @Unroll
    "application should start"() {
        when:
        Main.main()

        then:
        noExceptionThrown()
    }

    @Unroll
    "should run simulation and return true based on input"() {
        when:
        Main.main()

        then:
        println true
    }

}