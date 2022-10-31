package com.project.questapp.services;

import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.responses.repos.PostRepository;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.UpdatePostRequest;
import com.project.questapp.responses.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

   private PostRepository postRepository;
   private UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }


    public List<PostResponse> getAllPosts(Optional<Long> userId) {
        List<Post> list;
        if(userId.isPresent()){
            list= postRepository.findByUserId(userId.get());
        }
        else{
            list= postRepository.findAll();

        }
       return  list.stream().map(p ->new PostResponse(p)).collect(Collectors.toList());
    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPost) {
      User user=  userService.getOneUserById(newPost.getUserId());
      if(user==null){
          return null;
      }
      Post toSave = new Post();
      toSave.setId(newPost.getId());
      toSave.setText(newPost.getText());
      toSave.setTitle(newPost.getTitle());
      toSave.setUser(user);

        return postRepository.save(toSave);
    }


    public Post updateOnePostById(Long postId , UpdatePostRequest updatePostRequest) {
        Optional<Post> post= postRepository.findById(postId);
        if(post.isPresent()){
            Post toUpdate=post.get();
            toUpdate.setText(updatePostRequest.getText());
            toUpdate.setTitle(updatePostRequest.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deleteOnePostById(Long postId) {
         postRepository.deleteById(postId);
    }
}
