package com.zyp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.zyp.dao.CommentDao;
import com.zyp.entity.Comment;


public class CommentDaoImpl extends BaseDao implements CommentDao {

	@Override
	public boolean addComment(Comment comment) {
		// TODO Auto-generated method stub
		if(comment==null) {
			System.out.println("are you kiding me?");
			return false;
		}
		String sql="insert into comment (uId,mId,comment,comtime) values (?,?,?,?)";
		List<Object> params1 = new ArrayList<Object>();
		params1.add(comment.getuId());
		params1.add(comment.getmId());
		params1.add(comment.getComment());
		params1.add(comment.getComtime());
		return operUpdate(sql, params1);
	}

	@Override
	public boolean delComment(int conId) {
		// TODO Auto-generated method stub
		String sql = "delete from comment where conId=" + conId;
		return operUpdate(sql, null);
	}

	@Override
	public boolean updateComment(Comment comment) {
		// TODO Auto-generated method stub
		String sql = "update comment set uId=?,mId=?,comment=?,comtime=? where conId=?";
		List<Object> params1 = new ArrayList<Object>();
		params1.add(comment.getuId());
		params1.add(comment.getmId());
		params1.add(comment.getComment());
		params1.add(comment.getComtime());
		params1.add(comment.getConId());
		return operUpdate(sql, params1);
	}

	@Override
	public List<Comment> queryAllCommentByuId(int uId) {
		// TODO Auto-generated method stub
		String sql="select * from comment where uId="+uId;
		List<Comment> list=null;
		try {
			list = operQuery(sql, null,Comment.class);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Comment> queryAllCommentBymId(int mId) {
		// TODO Auto-generated method stub
		String sql="select * from comment where mId="+mId;
		List<Comment> list=null;
		try {
			list = operQuery(sql, null,Comment.class);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Comment queryComment(Comment comment) {
		// TODO Auto-generated method stub
		String sql="select * from comment where uId=? and mId=?";
		List<Object> params = new ArrayList<Object>();
		params.add(comment.getuId());
		params.add(comment.getmId());
		List<Comment> list=null;
		try {
			list = operQuery(sql,params,Comment.class);			
			if(list.size() == 0){
				return null;
			}else{
				return list.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	

}
