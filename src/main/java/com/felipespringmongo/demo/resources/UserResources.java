package com.felipespringmongo.demo.resources;


import com.felipespringmongo.demo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
         User maria = new User("1", "Maria silva", "maria@gmail.com");
         User pedro = new User("2", "pedro nobrega", "pedro@gmail.com" );
         List<User> list = new ArrayList<>();
         list.addAll(Arrays.asList(maria,pedro));
         return ResponseEntity.ok().body(list);
    }
}
