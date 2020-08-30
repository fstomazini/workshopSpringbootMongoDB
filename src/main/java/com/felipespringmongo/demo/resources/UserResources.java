package com.felipespringmongo.demo.resources;


import com.felipespringmongo.demo.domain.User;
import com.felipespringmongo.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
         List<User> list = service.findAll();
         return ResponseEntity.ok().body(list);
    }
}
