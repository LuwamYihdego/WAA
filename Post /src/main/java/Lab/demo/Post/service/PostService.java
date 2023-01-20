package Lab.demo.Post.service;

import Lab.demo.Post.domain.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post findById(long id);

    List<Post> findPostByAutor(String autor);

    void deletById(long id);

    Post creatPost(Post p);

    Post updatePost(long id, Post p);
}
