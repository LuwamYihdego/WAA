package waa.lab.RESTfulldemo.service;

import waa.lab.RESTfulldemo.domain.Post;
import waa.lab.RESTfulldemo.domain.dto.PostDetails;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    PostDetails findById(long id);

    void save(Post p);

    void delete(long id);


    void update(long id, Post p);

    List<Post> findPublishedBy(String publisher);
}
