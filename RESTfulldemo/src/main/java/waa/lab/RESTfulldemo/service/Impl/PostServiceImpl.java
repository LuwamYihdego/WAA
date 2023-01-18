package waa.lab.RESTfulldemo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.lab.RESTfulldemo.domain.Post;
import waa.lab.RESTfulldemo.domain.dto.PostDetails;
import waa.lab.RESTfulldemo.repository.PostRepo;
import waa.lab.RESTfulldemo.service.PostService;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public PostDetails findById(long id) {
        Post post = postRepo.findById(id);

        return new PostDetails(post.getTittle(), post.getContent());
    }

    @Override
    public void save(Post p) {
    postRepo.save(p);
    }

    @Override
    public void delete(long id) {
    postRepo.delete(id);
    }

    @Override
    public void update(long id, Post p) {
    postRepo.update(id, p);
    }

    @Override
    public List<Post> findPublishedBy(String publisher) {
        return postRepo.findPublishedBy(publisher);
    }


}
