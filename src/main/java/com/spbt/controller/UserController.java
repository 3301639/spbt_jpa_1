package com.spbt.controller;

import com.spbt.pojo.User;
import com.spbt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("all")
    public String all(Model model){
       List<User> result = userService.getUserAll();
        System.out.println("========================"+result.toString());
        model.addAttribute("userList", result);
        return "users";
    }
    @RequestMapping("delete")
    public String delete(Integer id){
        userService.deleteUserById(id);
        return "redirect:/user/all";
    }
    @RequestMapping("toadd")
    public String toadd(){
        return "addUser";
    }
    @RequestMapping("add")
    public String add(User user){
        userService.addUser(user);
        return "redirect:/user/all";
    }
    @RequestMapping("toupdate")
    public String toupdate(Integer id,Model model){
     User user = userService.getUserById(id);
        System.out.println("修改的数据是"+user.toString());
     model.addAttribute("user", user);
        return "update";
    }
    @RequestMapping("update")
    public String update(User user){
        userService.updateUser(user);
        return "redirect:/user/all";
    }
    @RequestMapping("/getUserByName")
    public String userByName(String username,Model model){
        System.out.println("username:"+username);
        User userByuserName = userService.getUserByuserName(username);
        model.addAttribute("userList",userByuserName);
        return "users";
    }
}
