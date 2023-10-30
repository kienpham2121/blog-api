package com.springboot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.blog.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	
}
