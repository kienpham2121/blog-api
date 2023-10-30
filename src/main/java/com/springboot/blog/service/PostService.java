package com.springboot.blog.service;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.payload.PostResponse;

public interface PostService {
	PostDto createPost(PostDto dto);

	PostResponse getAllPosts(int pageNo, int pageSize);
 }
