package com.scaler.basicapp.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaler.basicapp.Models.User;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    // ------------------------------------------------------------------------
    // GET Request:
    @GetMapping("/")
    public List<User> getUsers() {
        // users.add(new User("Suraj", "sp.com"));
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String str_id) {
        int id = Integer.parseInt(str_id);
        if (id <= 0 || id >= users.size())
            return null;
        User user = users.get(id);
        return user;
    }

    // ------------------------------------------------------------------------
    // POST Request:
    // param: {"name":"a","emailId":"a@gmail.com"}
    @PostMapping("/addOne")
    public User addOneUser(@RequestBody User user) {
        System.out.println("User added");
        users.add(user);
        return user;
    }

    // param =
    // [{"name":"a","emailId":"a@gmail.com"},{"name":"b","emailId":"b@gmail.com"}]
    @PostMapping("/addMany")
    public List<User> addManyUsers(@RequestBody List<User> userList) {
        System.out.println("Many User added");
        users.addAll(userList);
        return userList;
    }
}
