package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

class CameraTest extends Specification {

    @Unroll
    "camera shoud take a photo"() {
        given:
        def camera = new Camera()
        def position = new RoverPosition(1, 0)

        when:
        camera.takePhoto(position)

        then:
        camera.photos.size() == 1
    }

    @Unroll
    "camera shoud take just one photo"() {
        given:
        def camera = new Camera()
        def position1 = new RoverPosition(1, 0)
        def position2 = new RoverPosition(1, 1)
        def position3 = new RoverPosition(1, 0)

        when:
        camera.takePhoto(position1)
        camera.takePhoto(position2)
        camera.takePhoto(position3)

        then:
        camera.photos.size() == 2
    }
}
