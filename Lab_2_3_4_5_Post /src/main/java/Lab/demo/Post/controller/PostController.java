package Lab.demo.Post.controller;

import Lab.demo.Post.domain.Comment;
import Lab.demo.Post.domain.Post;
import Lab.demo.Post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;
    @GetMapping
    public List<Post> findAllPosts(){
        return postService.findAll();
    }
    @GetMapping("/{id}")
    public Post findPostById(@PathVariable long id){
        return postService.findById(id);
    }
    @DeleteMapping("/{id}")
    public String deletePostById(@PathVariable long id){
         postService.deletById(id);

         return "Deleted";
    }
    @PutMapping("/{id}")
    public Post updatePostById(@RequestBody Post post, @PathVariable long id){

       return  postService.updatePost(id , post);

    }
    @PostMapping
    public Post creatPost(@RequestBody Post post){
        return postService.creatPost(post);
    }
    @GetMapping("/autor")
    public List<Post> findPostByAutor(@RequestParam("autored") String autored){

        return postService.findPostByAutor(autored);
    }
    @PostMapping("/{id}/comment")
    public String creatCommentByPostId(@PathVariable long id, @RequestBody Comment comment){
        postService.creatComment(id,comment);

        return "created";

    }








}
