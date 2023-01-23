package Lab.demo.Post.controller;

import Lab.demo.Post.domain.Comment;
import Lab.demo.Post.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;


    @GetMapping
    public List<Comment> findAllComments(){
       return  commentService.findAll();
    }

    @GetMapping("/{id}")
    public Comment findById(@PathVariable long id){

       return  commentService.findById(id);

    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable long id){
        commentService.deletById(id);
        return "Deleted";
    }
    @PostMapping
    public Comment creatComment(@RequestBody Comment comment){
        return commentService.creatComment(comment);
    }
    @PutMapping("/{id}")
    public Comment updateComment(@RequestBody Comment comment, @PathVariable long id){

       return  commentService.updateComment(id,comment);

    }






}
