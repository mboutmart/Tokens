package com.izicap.demo.token.controller;


import com.izicap.demo.token.controller.dtos.TokenResponse;
import com.izicap.demo.token.controller.dtos.UserAndPassword;
import com.izicap.demo.token.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tokens")

public class TokenController {
    @Autowired
    TokenService tokenService;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse getOrCreateToken(@RequestBody UserAndPassword userAndPassword) {

        return new TokenResponse(tokenService.getOrCreateToken(userAndPassword.getUsername(), userAndPassword.getPassword()));
    }

}
