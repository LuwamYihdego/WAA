package Lab.demo.Post.service.Impl;

import Lab.demo.Post.domain.Post;
import Lab.demo.Post.domain.User;
import Lab.demo.Post.repository.UserRepo;
import Lab.demo.Post.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();

        userRepo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id).orElse(null);
    }



    @Override
    public List<Post> findUserPost(long id) {
        return userRepo.getUserPostsByUserId(id);
    }

    @Override
    public void deletById(long id) {
          userRepo.deleteById(id);
    }

    @Override
    public User creatUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(long id, User user) {

        User updateUser = userRepo.findById(id).orElse(null);
        updateUser.setId(user.getId());
        updateUser.setName(user.getName());
        updateUser.setPosts(user.getPosts());
        return updateUser;
    }



    @Override
    public List<User> getUserWithMoreThan1Post() {
        return userRepo.getUserWithPostGreaterThanOne();
    }
}
