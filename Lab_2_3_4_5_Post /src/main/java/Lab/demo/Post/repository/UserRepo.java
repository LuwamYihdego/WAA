package Lab.demo.Post.repository;

import Lab.demo.Post.domain.Post;
import Lab.demo.Post.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {

    @Query("select user from User user where size(user.posts) >=1 ")
    List<User> getUserWithPostGreaterThanOne();
    @Query("select user.posts from User user where user.id = :id")
    List<Post> getUserPostsByUserId(long id);
@Query("select user from User user where size(user.posts) >= :n")
    List<User> getUserWithMoreThanNPost(int n);

//    @Query("Select user.posts from User user where user.id = :id")
//    List<Post> getUserPosts(long id);
//
//
//
//
    @Query(value="SELECT * FROM USERS WHERE ID = SELECT USER_ID FROM POST WHERE title = :title", nativeQuery = true)
    List<User> getUserWhoPostedTitle(String title);

   // @Query(value= "SELECT * FROM USERS WHERE ID =:userId and :userId = SELECT USER_ID FROM POST WHERE ID =:postId and :postId = SELECT POST_ID FROM COMMENT WHERE ID =:commentId" , nativeQuery = true)

  //  @Query(value="SELECT u FROM User u INNER JOIN Post p ON u.id=p.u.id INNER JOIN Comment c ON p.id=c.p.id WHERE u.id = :userId AND p.id = : postId And c.id = :commentId");
  //  @Query(value = "SELECT c FROM User u INNER JOIN Post p ON u.id = p.user.id INNER JOIN Comment c ON p.id = c.post.id WHERE u.id = :userId AND p.id = :postId AND c.id = :commentId");
    Optional<User> getUserWhoPostedACommentWithID(long userId, long postId, long commentId);



}
