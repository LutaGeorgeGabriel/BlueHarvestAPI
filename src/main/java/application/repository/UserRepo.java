package application.repository;

import application.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    // the list acts as a persistence method (in-memory)
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    // method used in tests, for cleanup purposes
    public void dump() {
        this.users = new ArrayList<>();
    }
}
