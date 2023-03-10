package Lab.demo.Post.controller;

import Lab.demo.Post.domain.Post;
import Lab.demo.Post.domain.User;
import Lab.demo.Post.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
     @GetMapping
    public List<User> findAllUsers(){

       return  userService.findAll();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable long id){
         return userService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable long id){
         userService.deletById(id);
    }
  @PutMapping("/{id}")
  public void updateUserById(@PathVariable long id, @RequestBody User user){
         userService.updateUser(id, user);
  }
  @PostMapping()
  public User creatUser(@RequestBody User user){

         return userService.creatUser(user);

  }
@GetMapping("/{id}/posts")
public List<Post> findUserPosts(@PathVariable long id){

         return userService.findUserPost(id);
}

@GetMapping("/moreThanOnePost")
public List<User> getUserWithMoreThanOnePost(){

      return userService.getUserWithMoreThan1Post();
}

    @GetMapping("/greaterThan/{id}")
    public List<User> getUserWithMoreThanNPost(@PathVariable("id") int n){

        return userService.getUserWithMoreThanNPost(n);
    }
@GetMapping("/posts")
    public List<User> getUserWhoPostedTitle(@RequestParam("title") String title) {
        return userService.getUserWhoPostedTitle(title);
    }



}