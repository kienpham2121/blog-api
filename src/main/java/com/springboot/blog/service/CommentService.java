package com.springboot.blog.service;

import java.util.List;

import com.springboot.blog.payload.CommentDto;

public interface CommentService {
	public CommentDto createComment(int id, CommentDto commentDto);

	public List<CommentDto> getCommentsByPostId(int postId);

	public CommentDto getCommentById(Long postId, Long commentId);

	public CommentDto updateComment(Long postId, long commentId, CommentDto commentRequest);

	public void deleteComment(Long postId, Long commentId);
}
