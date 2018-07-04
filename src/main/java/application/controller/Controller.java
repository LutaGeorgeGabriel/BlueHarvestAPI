package application.controller;

import application.model.User;
import application.repository.UserRepo;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Controller {

    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    @PostMapping(value = "/create")
    public ResponseEntity createUser(@RequestBody User user) {
        userService.create(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/update/{initialCredit}")
    public ResponseEntity updateUser(@PathVariable double initialCredit, @RequestBody User user) {
        userService.update(user, initialCredit);
        return new ResponseEntity<>("post", HttpStatus.OK);
    }

    @GetMapping(value = "/fetch/{uuid}")
    public ResponseEntity fetchUser(@PathVariable UUID uuid) {
        User user = userRepo.getUsers()
                .stream()
                .filter(usr -> usr.getCustomerID().equals(uuid))
                .findFirst()
                .get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "fetch")
    public ResponseEntity fetchAllUsers() {
        return new ResponseEntity<>(userRepo.getUsers(), HttpStatus.OK);
    }
}
