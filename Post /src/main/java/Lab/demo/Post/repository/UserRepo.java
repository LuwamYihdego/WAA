package Lab.demo.Post.repository;

import Lab.demo.Post.domain.Post;
import Lab.demo.Post.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepo extends CrudRepository<User,Long> {
    @Query("select user from User user where user.posts.size")
    List<User> getUserWithPostGreaterThanOne();
    @Query("select user.posts from User user where user.id = :id")
    List<Post> getUserPostsByUserId(long id);



}
