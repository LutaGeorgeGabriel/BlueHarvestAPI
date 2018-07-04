package api

import application.Application
import application.model.User
import application.repository.UserRepo
import groovyx.net.http.RESTClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

import static application.utils.Utils.generateUUID

@SpringBootTest(classes = [Application], webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Stepwise
class APITest extends Specification {

    @Shared
    public def client = new RESTClient("http://localhost:8080")

    @Autowired
    public UserRepo userRepo


    def "Fetch user by UUID"() {
        given:
        def uuid = generateUUID()
        User user = new User(uuid, "John", "Doe", [])
        userRepo.addUser(user)

        when:
        def response = client.get(path: "/fetch/${uuid}")

        then:
        response.status == 200
        with(response.responseData) {
            name == "John"
            surname == "Doe"
        }

        cleanup:
        userRepo.dump()
    }

    def "Fetch all users"() {
        given:
        def uuidOne = generateUUID()
        def uuidTwo = generateUUID()
        User userOne = new User(uuidOne,"John","Doe", [])
        User userTwo = new User(uuidTwo,"Jane","Doe", [])
        userRepo.addUser(userOne)
        userRepo.addUser(userTwo)

        when:
        def response = client.get(path: "/fetch")

        then:
        response.status == 200
        with(response) {
            responseData.size() == 2
            responseData[0].name == "John"
            responseData[1].name == "Jane"
        }

        cleanup:
        userRepo.dump()
    }
}
