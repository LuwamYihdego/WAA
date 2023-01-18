package waa.lab.RESTfulldemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import waa.lab.RESTfulldemo.domain.Post;
import waa.lab.RESTfulldemo.domain.dto.PostDetails;
import waa.lab.RESTfulldemo.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    PostService postService;
    @GetMapping
    public List<Post> findAll(){

        return postService.findAll();
    }
    @GetMapping("/{id}")
    public PostDetails findPostById(@PathVariable("id") long id){
        return postService.findById(id);
    }

    @GetMapping("/published")
    public List<Post> filterPostsByPublisher(@RequestParam("publisher") String publisher ){
        return postService.findPublishedBy(publisher);
    }
    @PostMapping
    public void savePost(@RequestBody Post post){

        postService.save(post);

    }

    @DeleteMapping("/{id}")
    public void deletPostById(@PathVariable long id){
        postService.delete(id);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable("id") long id, @RequestBody Post post){
        postService.update(id, post);
    }


}
