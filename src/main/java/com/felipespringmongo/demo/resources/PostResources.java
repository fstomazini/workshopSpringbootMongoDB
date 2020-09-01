package com.felipespringmongo.demo.resources;


import com.felipespringmongo.demo.domain.Post;
import com.felipespringmongo.demo.domain.User;
import com.felipespringmongo.demo.dto.UserDTO;
import com.felipespringmongo.demo.resources.util.URL;
import com.felipespringmongo.demo.services.PostService;
import com.felipespringmongo.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {
    @Autowired
    private PostService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll(){
         List<Post> list = service.findAll();

         return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "txt", defaultValue = "") String txt){
        txt = URL.decodeParam(txt);
        List<Post> list = service.findByTitle(txt);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/searchtitle", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> searchTitle(@RequestParam(value = "txt", defaultValue = "") String txt){
        txt = URL.decodeParam(txt);
        List<Post> list = service.findByTitle(txt);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "txt", defaultValue = "") String txt, @RequestParam(value = "minDate", defaultValue = "")String minDate, @RequestParam(value = "maxDate", defaultValue = "")String maxDate){
        txt = URL.decodeParam(txt);
        Date min = URL.convertDateToString(minDate, new Date(0l));
        Date max = URL.convertDateToString(maxDate, new Date(0l));
        List<Post> list = service.fullSearch(txt,min,max);
        return ResponseEntity.ok().body(list);
    }

}
