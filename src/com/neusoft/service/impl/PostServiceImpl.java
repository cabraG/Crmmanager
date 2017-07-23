package com.neusoft.service.impl;

import java.util.List;

import com.neusoft.dao.PostDao;
import com.neusoft.dao.impl.PostDaoImpl;
import com.neusoft.domain.Page;
import com.neusoft.domain.Post;
import com.neusoft.service.PostService;

public class PostServiceImpl implements PostService {

	private PostDao postDao = new PostDaoImpl();
	
	@Override
	public List<Post> getPostByDepId(String depId) {
		return postDao.getPostByDepId(depId);
	}

	@Override
	public Page getPagePostList(Post post, int pagenum, int pagesize) {
		Page page=new Page();
		page.setPagenum(pagenum);
		page.setPagesize(pagesize);
		page.setCount(postDao.getPageListCount(post));
		page.setPostlist(postDao.getListPost(post, pagenum, pagesize));
		page.setPages((page.getCount()%page.getPagesize()==0)?page.getCount()/page.getPagesize():page.getCount()/page.getPagesize()+1);
		return page;
		
	}

	@Override
	public Post getDepPostbyPostId(String postId) {
		// TODO Auto-generated method stub
		Post post=new Post();
		post=postDao.getDepPost(postId);
		return post;
		
	}

	@Override
	public void updatePost(Post post) {
		postDao.updataPost(post);
		
	}

	@Override
	public void insertPost(Post post) {
		postDao.insertPost(post);
		
	}

}
