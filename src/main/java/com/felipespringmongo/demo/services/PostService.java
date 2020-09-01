package com.felipespringmongo.demo.services;

import com.felipespringmongo.demo.domain.Post;

import com.felipespringmongo.demo.repository.PostRepository;
import com.felipespringmongo.demo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll(){
        return repository.findAll();
    }

    public Post findById(String id){
        Optional<Post> Post = repository.findById(id);
        return Post.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado"));
    }

    public List<Post> findByTitle(String txt){
        return repository.findByTitleContainingIgnoreCase(txt);
    }


}
