package com.springboot.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;

@RestController
@RequestMapping("/api/v1")
public class CommentController {

	@Autowired
	CommentService commentService;

	@PostMapping("/posts/{postId}/comment")
	public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") int postId,
			@RequestBody CommentDto commentDto) {
		return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
	}
	@GetMapping("/posts/{postId}/comment")
	public ResponseEntity<List<CommentDto>> getListCommentByPostId(@PathVariable(value = "postId") int postId){
		return new ResponseEntity<>(commentService.getCommentsByPostId(postId), HttpStatus.OK);
	}

}
