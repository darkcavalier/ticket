package com.zyp.service.impl;

import java.util.List;

import com.zyp.dao.SessionDao;
import com.zyp.dao.impl.SessionDaoImpl;
import com.zyp.entity.Session;
import com.zyp.service.SessionService;

public class SessionServiceImpl implements SessionService {
 
	private SessionDao sessionDao;
	public SessionServiceImpl() {
		sessionDao=new SessionDaoImpl() ;
	}
	@Override
	public int addSession(Session session) {
		// TODO Auto-generated method stub
		Session s=sessionDao.querySession(session);
		if(s==null) {
			boolean res_add=sessionDao.addSession(session);
			if(res_add) {
				return 1;//添加成功
			}else {
				return 2;//添加失败
			}
		}
		return 3;//添加失败
	}

	@Override
	public boolean delSession(int sId) {
		// TODO Auto-generated method stub
		return sessionDao.delSession(sId);
	}

	@Override
	public boolean updateSession(Session session) {
		// TODO Auto-generated method stub
		return sessionDao.updateSession(session);
	}

	@Override
	public List<Session> queryAllSession() {
		// TODO Auto-generated method stub
		return sessionDao.queryAllSession();
	}
	@Override
	public List<Session> querySessionBymId(int mId) {
		// TODO Auto-generated method stub
		return sessionDao.querySessionByMid(mId);
	}
	@Override
	public Session querySessionById(int sId) {
		// TODO Auto-generated method stub
		return sessionDao.querySessionById(sId);
	}
	@Override
	public List<Session> querySessionByHid(int hId) {
		// TODO Auto-generated method stub
		return sessionDao.querySessionByHid(hId);
	}
	@Override
	public List<Session> querySessionBycIdandmId(int cId, int mId) {
		// TODO Auto-generated method stub
		return sessionDao.querySessionBycIdandmId(cId, mId);
	}
	@Override
	public List<Session> querySessionBycId(int cId) {
		// TODO Auto-generated method stub
		return sessionDao.querySessionByCid(cId);
	}

}
