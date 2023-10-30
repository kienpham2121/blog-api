package com.springboot.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.payload.PostResponse;
import com.springboot.blog.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/create")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postRequest) {
		return new ResponseEntity<PostDto>(postService.createPost(postRequest), HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value = "pageNo" , defaultValue = "0", required = false) int pageNo,
			@RequestParam(value = "pageSize" , defaultValue = "10", required = false) int pageSize) {
		return ResponseEntity.ok(postService.getAllPosts(pageNo, pageSize));
	}
}
