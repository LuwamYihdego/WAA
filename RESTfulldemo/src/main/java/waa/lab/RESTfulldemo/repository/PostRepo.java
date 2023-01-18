package waa.lab.RESTfulldemo.repository;

import waa.lab.RESTfulldemo.domain.Post;

import java.util.List;

public interface PostRepo {

    List<Post> findAll();

    Post findById(long id);

    void save(Post p);

    void delete(long id);


    void update(long id, Post p);

    List<Post> findPublishedBy(String publisher);






}
