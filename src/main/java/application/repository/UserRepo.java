package application.repository;

import application.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {
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

    public void dump() {
        this.users = new ArrayList<>();
    }
}
