package com.project.questapp.responses.repos;

import com.project.questapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByUserId(Long userId);// FindBy"param name" jpa fill automatically
}
