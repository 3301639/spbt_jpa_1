package com.spbt.service;

import com.spbt.pojo.User;
import org.springframework.data.jpa.repository.Query;

import javax.naming.Name;
import java.util.List;

public interface UserService {
    List<User> getUserAll();
    void deleteUserById(Integer id);
    Integer updateUser(User user);
    User getUserById(Integer id);
    Integer addUser(User user);

    User getUserByuserName(String username);

}
