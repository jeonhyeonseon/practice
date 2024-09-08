package com.sh.jpa_practice.post.service;

import com.sh.jpa_practice.post.dto.PostRequestDto;
import com.sh.jpa_practice.post.dto.PostResponseDto;
import com.sh.jpa_practice.post.entity.Post;
import com.sh.jpa_practice.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // post 등록
    public Long regist(PostRequestDto postRequestDto) {
        Post post = postRepository.save(postRequestDto.toPost());
        return post.getId();
    }

    // 게시물 모두 조회
    public List<PostResponseDto> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(PostResponseDto::fromPost)
                .collect(Collectors.toList());
    }

    // 게시물 수정
    /**
     * 1. 엔티티 조회
     * (optional이 뭘까) -> 생각하기
     * 2. 수정할 대상이 없을 경우 예외처리
     * @param id
     * @param updateDto
     * @return
     */
    public Long update(Long id, PostRequestDto updateDto) {
        return postRepository.update(id, updateDto);
    }

    // 게시물 삭제
    /**
     * 1. 삭제 시 엔티티 조회 후 삭제하기
     * @param id
     */
    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
    }
}
