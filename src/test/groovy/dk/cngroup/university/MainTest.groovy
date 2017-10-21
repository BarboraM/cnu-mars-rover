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
}