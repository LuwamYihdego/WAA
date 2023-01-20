package Lab.demo.Post.service;

import Lab.demo.Post.domain.Post;
import Lab.demo.Post.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(long id);



    void deletById(long id);

    User creatUser(User user);

    User updateUser(long id, User user);

   List<Post> findUserPost(long id);
   List<User> getUserWithMoreThan1Post();
}
