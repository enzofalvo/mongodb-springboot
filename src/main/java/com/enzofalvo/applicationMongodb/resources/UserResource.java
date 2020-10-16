package com.enzofalvo.applicationMongodb.resources;

import com.enzofalvo.applicationMongodb.domain.User;
import com.enzofalvo.applicationMongodb.services.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService service;

    //method to get all users with the endpoint
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <List<User>> findAll() {
        //find in database with service
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
