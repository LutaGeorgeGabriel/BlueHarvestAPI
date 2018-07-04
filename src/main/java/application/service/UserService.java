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
                    if ($user.getCustomerID().equals(user.getCustomerID())) {
                        Account account = accountService.create($user, initialCredit);
                        $user.addAccount(account);
                    }
                    return $user;
                })
                .collect(Collectors.toList());

        userRepo.setUsers(users);
    }
}
