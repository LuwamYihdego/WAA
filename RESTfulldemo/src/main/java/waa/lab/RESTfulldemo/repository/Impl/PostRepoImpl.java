package waa.lab.RESTfulldemo.repository.Impl;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import waa.lab.RESTfulldemo.domain.Post;
import waa.lab.RESTfulldemo.repository.PostRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {

List<Post> posts = new ArrayList<>(Arrays.asList(

        new Post(123, "Movie", "Stranger Things", "Netflix"),
        new Post(124, "Reality Show", "Keeping Up With the Kardashian", "Hulu"),
        new Post(125, "Documentary", "What is a women", "YouTube"),
        new Post(126, "Song", "We are the World", "Spotify"),
         new Post(127, "Pod-cust", "Love and Light", "Podcusts"),
             new Post(129, "Show", "The Real House Wives", "YouTube")
));


    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(long id) {
        return posts.stream().filter(a -> a.getId()==id).findFirst().orElse(null);
    }

    @Override
    public void save(Post p) {

        posts.add(p);

    }

    @Override
    public void delete(long id) {
     var p= posts.stream().filter(a -> a.getId()==id).findFirst().orElse(null);
        posts.remove(p);
    }



    @Override
    public void update(long id, Post p) {

        var pp = posts.stream().filter(a ->a.getId()==id).findFirst().orElse(null);

        pp.setId(p.getId());
        pp.setTittle(p.getTittle());
        pp.setContent(p.getContent());
        pp.setPublisher(p.getPublisher());

    }

    public List<Post> findPublishedBy(String publisher){
        return posts.stream().filter(a -> a.getPublisher()==publisher).collect(Collectors.toList());


    }



}
