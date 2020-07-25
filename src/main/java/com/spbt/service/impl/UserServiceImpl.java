package com.spbt.service.impl;

import com.spbt.dao.UserDao;
import com.spbt.pojo.User;
import com.spbt.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.naming.Name;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
   private UserDao userDao;


    @Override
    public List<User> getUserAll() {
        return userDao.findAll();
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public Integer updateUser(User user) {
        userDao.save(user);
        return 1;
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getOne(id);
    }

    @Override
    public Integer addUser(User user) {
       User result = userDao.save(user);
       if(result != null){
           return 1;
       }else {
           return 0;
       }
    }

    @Override
    public User getUserByuserName(String username) {
        return userDao.getUserByuserName(username);
    }
}