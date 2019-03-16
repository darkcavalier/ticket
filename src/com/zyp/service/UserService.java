package com.zyp.service;

import com.zyp.entity.User;

public interface UserService {
	public User login(User user);//登录用户

	public int register(User user);//注册用户
    public  User queryUser(User user);//返回用户
	public User queryUserByName(String uName);//根据名字查找id
	public boolean updateUserPass(User user,String pass);//更新密码
	public boolean updateUser(User user);//更新
	public User queryUserByid(int uid);//根据id查找用户
}
