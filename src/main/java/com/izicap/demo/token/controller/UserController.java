package com.izicap.demo.token.controller;


import com.izicap.demo.token.controller.dtos.UserAndPassword;
import com.izicap.demo.token.entities.Token;
import com.izicap.demo.token.entities.User;
import com.izicap.demo.token.errors.UnauthorizedException;
import com.izicap.demo.token.services.TokenService;
import com.izicap.demo.token.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestHeader(value="Authorization") String adminToken, @RequestBody UserAndPassword userAndPassword) {
        String[] tokenHeader = adminToken.split(" ");
        if (tokenHeader.length== 2 && tokenHeader[0].equalsIgnoreCase("bearer")) {
            return userService.createUser(tokenHeader[1], userAndPassword.getUsername(), userAndPassword.getPassword());
        }
        throw new UnauthorizedException();
    }


    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<User> all() {

        return userService.all();
    }
}
