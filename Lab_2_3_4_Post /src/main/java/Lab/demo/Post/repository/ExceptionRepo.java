package Lab.demo.Post.repository;

import Lab.demo.Post.domain.MyException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepo extends CrudRepository<MyException,Long> {
}
