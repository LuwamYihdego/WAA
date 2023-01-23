package Lab.demo.Post.repository;

import Lab.demo.Post.domain.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepo extends CrudRepository<Post,Long> {
    @Query("select post from Post post where post.autor = :autor")
    List<Post> findPostByAutor(String autor);

}
