package application.service;

import application.model.Account;
import application.model.User;
import application.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static application.utils.Utils.generateUUID;

public class UserService {

    @Autowired
    AccountService accountService;

    @Autowired
    UserRepo userRepo;

    public void create(User user) {
        user.setCustomerID(generateUUID());
        userRepo.addUser(user);
    }

    public void update(User user, double initialCredit) {
        List<User> users = userRepo.getUsers().stream()
                .map($user -> {
                    // filtering for the user with the received uuid
                    if ($user.getCustomerID().equals(user.getCustomerID())) {
                        // creating account linked to the respective user
                        Account account = accountService.create($user, initialCredit);
                        // adding the account to the user's account list
                        $user.addAccount(account);
                    }
                    return $user;
                })
                .collect(Collectors.toList());

        userRepo.setUsers(users);
    }
}
