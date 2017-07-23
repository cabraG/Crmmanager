package com.neusoft.service;

import java.util.List;

import com.neusoft.domain.Page;
import com.neusoft.domain.Post;

public interface PostService {

	/*
	 * 根据部门id查询所有的职务
	 */
	public List<Post> getPostByDepId(String depId);
	
	
	
	
	public Page getPagePostList(Post post,int pagenum,int pagesize);
	public Post getDepPostbyPostId(String postId);
	public void updatePost(Post post);
	public void insertPost(Post post);
	
	
}
