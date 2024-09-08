package com.sh.jpa_practice.post.controller;

import com.sh.jpa_practice.post.dto.PostRequestDto;
import com.sh.jpa_practice.post.dto.PostResponseDto;
import com.sh.jpa_practice.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
@Slf4j
public class PostController {
    private final PostService postService;

    // 게시물 등록
    @PostMapping("")
    public Long regist(@RequestBody PostRequestDto postRequestDto) {
        return postService.regist(postRequestDto);
    }

    // 전체 게시물 조회
    @GetMapping
    public List<PostResponseDto> findAll(){
        return postService.findAll();
    }

    // 게시물 수정
    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostRequestDto updateDto){
        return postService.update(id, updateDto);
    }

    // 게시물 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }
}
