package com.sh.jpa_practice.post.repository;

import com.sh.jpa_practice.post.dto.PostRequestDto;
import com.sh.jpa_practice.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Long update(Long id, PostRequestDto updateDto);
}
