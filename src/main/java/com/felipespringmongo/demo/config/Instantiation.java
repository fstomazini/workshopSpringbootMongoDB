package com.felipespringmongo.demo.config;

import com.felipespringmongo.demo.domain.Post;
import com.felipespringmongo.demo.domain.User;
import com.felipespringmongo.demo.dto.AuthorDTO;
import com.felipespringmongo.demo.dto.CommentDTO;
import com.felipespringmongo.demo.repository.PostRepository;
import com.felipespringmongo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class  Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null,sdf.parse("21/03/2018"), "Partiu Viagem ","vou viajar para São Paulo. Abraços", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/11/2018"), "bom dia", "Acordei Feliz hoje!! :D",new AuthorDTO(maria) );

        CommentDTO comment1 = new CommentDTO("Boa viagem Mano", sdf.parse("21/13/2018"), new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Aproveite", sdf.parse("23/03/2018"), new AuthorDTO(bob));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(comment1,comment2));
        post2.getComments().add(comment3);
        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);

    }
}
