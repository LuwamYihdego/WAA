package Lab.demo.Post.repository;

import Lab.demo.Post.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment,Long> {
}
