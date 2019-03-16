package com.zyp.service.impl;

import com.zyp.dao.UserDao;
import com.zyp.dao.impl.UserDaoImpl;
import com.zyp.entity.User;
import com.zyp.service.UserService;



public class UserServiceImpl implements UserService {
	private UserDao mUserDao;
	public UserServiceImpl() {
		mUserDao=new UserDaoImpl();				
	}
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return mUserDao.queryUser(user);
	}
    
	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		User u = mUserDao.queryUserByName(user.getuName());
		if (u == null) {
			boolean res_add = mUserDao.addUser(user);
			if (res_add) {
				return 1;//注册成功
			} else {
				return 2;//注册失败
			}

		}
		return 3;//注册失败-用户名已存在
	}

	@Override
	public User queryUserByName(String uName) {
		// TODO Auto-generated method stub
		return mUserDao.queryUserByName(uName);
	}
	@Override
	public boolean updateUserPass(User user,String pass) {
		// TODO Auto-generated method stub
		return mUserDao.updateUserPass(user,pass);
	}
	@Override
	public User queryUser(User user) {
		// TODO Auto-generated method stub
		return mUserDao.queryUser(user);
	}
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return mUserDao.updateUser(user);
	}
	@Override
	public User queryUserByid(int uid) {
		// TODO Auto-generated method stub
		return mUserDao.queryUserByid(uid);
	}

}
