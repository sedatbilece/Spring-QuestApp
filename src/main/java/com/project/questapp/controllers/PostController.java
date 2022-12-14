package com.project.questapp.controllers;

import com.project.questapp.entities.Post;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.UpdatePostRequest;
import com.project.questapp.responses.PostResponse;
import com.project.questapp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }



    @GetMapping
    public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId){//RequestParam /posts/userId=3
        return postService.getAllPosts(userId);
    }


    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){//PathVariable /posts/3
              return postService.getOnePostById(postId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest){
        return postService.createOnePost(newPostRequest);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId , @RequestBody UpdatePostRequest updatePostRequest){

        return postService.updateOnePostById(postId,updatePostRequest);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
         postService.deleteOnePostById(postId);
    }


}
