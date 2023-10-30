package com.springboot.blog.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.repository.CommentRepository;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public CommentDto createComment(int postId, CommentDto commentDto) {

		Comment comment = mapper.map(commentDto, Comment.class);

		/* Check exist post by id */
		Post post = postRepository.findById(Long.valueOf(postId)).orElseThrow();
		comment.setPost(post);

		/* Insert new comment in DB */
		Comment newComment = commentRepository.save(comment);

		CommentDto commentResponse = mapper.map(newComment, CommentDto.class);

		return commentResponse;
	}

	@Override
	public List<CommentDto> getCommentsByPostId(int postId) {
		// retrieve comments by postId
		List<Comment> comments = commentRepository.findByPostId(Long.valueOf(postId));

		// convert list of comment entities to list of comment dto's
		return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
		return null;
	}

	@Override
	public CommentDto getCommentById(Long postId, Long commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentDto updateComment(Long postId, long commentId, CommentDto commentRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComment(Long postId, Long commentId) {
		// TODO Auto-generated method stub
		
	}
}
