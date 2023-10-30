package com.springboot.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.payload.PostResponse;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public PostDto createPost(PostDto dto) {

		Post post = mapper.map(dto, Post.class);

		/* Insert new post to DB */
		Post newPost = postRepository.save(post);

		PostDto postDto = mapper.map(newPost, PostDto.class);

		return postDto;
	}

	@Override
	public PostResponse getAllPosts(int pageNo, int pageSize) {
		
		/* Create new instance pageable*/
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		/* Get all post in DB */
		Page<Post> post = postRepository.findAll(pageable);

		List<PostDto> postDto = post.getContent().stream()
				.map(p-> mapper.map(p, PostDto.class)).collect(Collectors.toList());

		PostResponse postResponse = PostResponse.builder()
				.posts(postDto)
				.pageNo(post.getNumber())
				.pageSize(post.getSize())
				.totalElement((int)post.getTotalElements())
				.totalPages(post.getTotalPages())
				.last(post.isLast()).build();

		return postResponse;
	}

}
