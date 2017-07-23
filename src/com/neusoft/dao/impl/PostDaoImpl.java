package com.neusoft.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.PostDao;
import com.neusoft.domain.Post;
import com.neusoft.util.C3P0Utils;

public class PostDaoImpl implements PostDao {

	@Override
	public List<Post> getPostByDepId(String depId) {
		String sql = "select * from crm_post p where p.depId = ?";

		try {
			QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

			return runner.query(sql, new BeanListHandler<Post>(Post.class),
					depId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Post> getListPost(Post post, int pagenum, int pagesize) {
		try {
			StringBuffer sql = new StringBuffer(
					"select p.*,d.depName from crm_post p,crm_department d where p.depId = d.depId");
			List<Object> list = new ArrayList<Object>();
			if (post.getDepId() != null && !post.getDepId().trim().isEmpty()) {
				sql.append(" and d.depId= ? ");
				list.add(post.getDepId());
			}
			if (post.getPostName() != null && !post.getPostName().trim().isEmpty()) {
				sql.append(" and p.postName like ? ");
				list.add("%"+post.getPostName()+"%");
			}
			sql.append(" limit ?,?");
			list.add((pagenum - 1) * pagesize);
			list.add(pagesize);
			QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

			return runner.query(sql.toString(), new BeanListHandler<Post>(
					Post.class), list.toArray());

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getPageListCount(Post post) {
		try {
			StringBuffer sql = new StringBuffer(
					"select count(p.postId) from crm_post p,crm_department d where p.depId = d.depId");
			List<Object> list = new ArrayList<Object>();
			if (post.getDepId() != null && !post.getDepId().trim().isEmpty()) {
				sql.append(" and d.depId= ? ");
				list.add(post.getDepId());
			}
			if (post.getPostName() != null && !post.getPostName().trim().isEmpty()) {
				sql.append(" and p.postName like ? ");
				list.add("%"+post.getPostName()+"%");
			}
			QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
			
				return ((Long) runner.query(sql.toString(), new ScalarHandler(),list.toArray())).intValue();
			
		
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
		
	

}

	@Override
	public Post getDepPost(String postid) {
		try {
		String sql="select p.*,d.depName from crm_post p,crm_department d where p.depId = d.depId and p.postId=?";
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
		
			return runner.query(sql, new BeanHandler<Post>(Post.class),
					postid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updataPost(Post post) {
		try {
		String sql="update crm_post  set postName=?,depId=? where postId=?";
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
	
			runner.update(sql,post.getPostName(),post.getDepId(),post.getPostId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertPost(Post post) {
		String sql="insert into crm_post values(uuid(),?,?)";
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		try {
			runner.update(sql,post.getPostName(),post.getDepId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
