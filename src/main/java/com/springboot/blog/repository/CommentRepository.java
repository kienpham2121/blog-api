package com.springboot.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.blog.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	List<Comment> findByPostId(long postId);
}
