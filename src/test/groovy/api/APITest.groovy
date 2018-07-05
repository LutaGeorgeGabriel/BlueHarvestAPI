package api

import application.Application
import application.model.User
import application.repository.UserRepo
import groovyx.net.http.RESTClient
import spock.lang.Specification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Shared
import spock.lang.Stepwise

import static application.utils.Utils.generateUUID
import static groovyx.net.http.ContentType.JSON

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

    def "Create new account for updated user"() {
        given:
        User user = new User(UUID.fromString("d26fb9d4-875a-4041-b684-9c8e91eb7aca"),"John","Doe", [])
        userRepo.addUser(user)
        def response = null

        when:
        def result = client.post(path: "/update/0",
                requestContentType: JSON,
                body: [ customerID: "d26fb9d4-875a-4041-b684-9c8e91eb7aca"]) { resp ->
            response = resp.status
        }

        then:
        response == 200

        cleanup:
        userRepo.dump()
    }

    def "Create new user"() {
        given:
        def response = null

        when:
        def result = client.post(path: "/create",
                requestContentType: JSON,
                body: [
                        customerID: "d26fb9d4-875a-4041-b684-9c8e91eb7aca",
                        name: "John",
                        surname: "Doe" ]) {resp -> response = resp.status}

        then:
        response == 200
        with(userRepo){
            users.get(0).name == "John"
            users.get(0).surname == "Doe"
        }
    }
}
