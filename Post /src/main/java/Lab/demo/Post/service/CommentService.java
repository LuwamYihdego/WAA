package Lab.demo.Post.service;

import Lab.demo.Post.domain.Comment;
import Lab.demo.Post.domain.Post;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment findById(long id);

    void deletById(long id);

    Comment creatComment(Comment p);

    Comment updateComment(long id, Comment comment);
}
