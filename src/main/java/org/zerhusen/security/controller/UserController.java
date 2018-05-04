package org.zerhusen.security.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.zerhusen.security.repository.AuthorityController;
import org.zerhusen.security.repository.UserControoller;



@CrossOrigin(origins = {"*"}, maxAge = 3600)
@PreAuthorize("hasRole('ADMIN')")
@RestController
public class UserController {
    private static final Long ADMIN = 2l;
    private static final Long USER = 1l;
    private static final String ROLE_ADMIN = "ROLE_ADMIN";

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserControoller controller;

    @Autowired
    AuthorityController authorityController;


    ObjectMapper mapper = new ObjectMapper();


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create_user/{authority}", method = RequestMethod.PUT)
    public String createUser(@RequestBody String message) {


        return message;
    }


}
