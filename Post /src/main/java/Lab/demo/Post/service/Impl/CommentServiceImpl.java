package Lab.demo.Post.service.Impl;

import Lab.demo.Post.domain.Comment;
import Lab.demo.Post.repository.CommentRepo;
import Lab.demo.Post.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;
    @Override
    public List<Comment> findAll() {

        List<Comment> list = new ArrayList<>();

        commentRepo.findAll().forEach(list::add);

            return list;
    }

    @Override
    public Comment findById(long id) {
        return commentRepo.findById(id).orElse(null);
    }



    @Override
    public void deletById(long id) {

        commentRepo.deleteById(id);

    }

    @Override
    public Comment creatComment(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public Comment updateComment(long id, Comment comment) {

       Comment updatedComment =  commentRepo.findById(id).orElse(null);
       updatedComment.setName(comment.getName());
        return updatedComment;
    }
}
