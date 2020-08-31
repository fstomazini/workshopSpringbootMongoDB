package com.felipespringmongo.demo.services;

import com.felipespringmongo.demo.domain.User;
import com.felipespringmongo.demo.repository.UserRepository;
import com.felipespringmongo.demo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado"));
    }

}
