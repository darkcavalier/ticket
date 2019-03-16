package com.zyp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.zyp.dao.UserDao;
import com.zyp.entity.Ticket;
import com.zyp.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		if(user == null) {
			return false;
		}
		String sql="insert into user (uName,uPass,balance,uType) values(?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getuName());
		params.add(user.getuPass());
		params.add(user.getBalance());
		params.add(user.getuType());
		return operUpdate(sql, params);
	}

	@Override
	public boolean delUser(int uid) {
		// TODO Auto-generated method stub
		String sql="delete from user  where uId="+uid;
		
		return operUpdate(sql, null);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		String sql="update user set uName=?,uPass=?,balance=?,uType=? where uId=?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getuName());
		params.add(user.getuPass());
		params.add(user.getBalance());
		params.add(user.getuType());
		params.add(user.getUid());
		return operUpdate(sql,params);
	}

	@Override
	public User queryUser(User user) {
		// TODO Auto-generated method stub
		String sql = "select * from User where uName=? and uPass=? and uType=?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getuName());
		params.add(user.getuPass());
		params.add(user.getuType());
		List<User> list = null;
		try {
			list = operQuery(sql,params,User.class);			
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

	@Override
	public User queryUserByName(String uName) {
		// TODO Auto-generated method stub
		String sql = "select uId from User where uName=? ";
		List<Object> params = new ArrayList<Object>();
		params.add(uName);
		List<User> list = null;
		try {
			list = operQuery(sql,params,User.class);

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

	@Override
	public boolean updateUserPass(User user,String pass) {
		// TODO Auto-generated method stub
		String sql="update user set uPass=? where uName=?";
		List<Object> params = new ArrayList<Object>();
		params.add(pass);
		params.add(user.getuName());
		return operUpdate(sql,params);
	}

	@Override
	public User queryUserByid(int uid) {
		// TODO Auto-generated method stub
		String sql="select * from user where uId="+uid;
		List<User> list=null;
		try {
			list = operQuery(sql, null,User.class);
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
