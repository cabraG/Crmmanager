package com.neusoft.dao;

import java.util.List;

import com.neusoft.domain.Post;

public interface PostDao {

	/*
	 * 根据部门id查询所有的职务
	 */
	public List<Post> getPostByDepId(String depId);
	public List<Post> getListPost(Post post,int pagenum,int pagesize);
	public int getPageListCount(Post post);
	public Post getDepPost(String postid);
	public void updataPost(Post post);
	public void insertPost(Post post);
}
