package Lab.demo.Post.service.Impl;

import Lab.demo.Post.domain.Post;
import Lab.demo.Post.repository.PostRepo;
import Lab.demo.Post.repository.UserRepo;
import Lab.demo.Post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
  @Autowired
  PostRepo postRepo;


    @Override
    public List<Post> findAll() {
        List<Post> list = new ArrayList<>();
        postRepo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Post findById(long id) {
        return postRepo.findById(id).orElse(null);
    }

    @Override
    public List<Post> findPostByAutor(String autor) {
        return postRepo.findPostByAutor(autor);
    }



    @Override
    public void deletById(long id) {
      postRepo.deleteById(id);

    }

    @Override
    public Post creatPost(Post p) {
       return  postRepo.save(p);
    }

    @Override
    public Post updatePost(long id, Post p) {
       Post updatedPost =  postRepo.findById(id).orElse(null);
       updatedPost.setId(p.getId());
       updatedPost.setAutor(p.getAutor());
       updatedPost.setTitle(p.getTitle());
       updatedPost.setContent(p.getContent());
      return updatedPost;
    }




}
