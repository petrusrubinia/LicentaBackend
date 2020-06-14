package com.backLicenta.user.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.backLicenta.user.domain.User;
import com.backLicenta.user.service.IUserService;

@EnableAutoConfiguration
@RequestMapping(value ="/user")
@RestController
public class UserAPI {
    private final IUserService userService;

    @Autowired
    public UserAPI(final IUserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/audentificare", method = RequestMethod.POST)
    public User login(@RequestBody User user){
        return userService.login(user);
    }

    @RequestMapping(value = "/inregistrare", method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        return userService.add(user);
    }

    @RequestMapping(value = "/modificare", method = RequestMethod.POST)
    public Boolean saveChanges(@RequestBody User newUser){

        return userService.saveChanges(newUser);
    }



}
