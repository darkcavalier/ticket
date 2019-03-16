package com.zyp.service.impl;

import java.util.List;

import com.zyp.dao.HallDao;
import com.zyp.dao.impl.HallDaoImpl;
import com.zyp.entity.Hall;
import com.zyp.service.HallService;

public class HallServiceImpl implements HallService {
 private HallDao hallDao=new HallDaoImpl();
 
	@Override
	public int addHall(Hall hall) {
		// TODO Auto-generated method stub
		Hall h=hallDao.queryHall(hall);
		if(h==null) {
			boolean res_add=hallDao.addHall(hall);
			if (res_add) {
				return 1;//添加成功
			}else {
				return 2;//添加失败
			}
		}
		return 3;//添加失败
	}

	@Override
	public boolean delHall(int hId) {
		// TODO Auto-generated method stub
		return hallDao.delHall(hId);
	}

	@Override
	public boolean updateHall(Hall hall) {
		// TODO Auto-generated method stub
		return hallDao.updateHall(hall);
	}

	@Override
	public List<Hall> queryAllHall() {
		// TODO Auto-generated method stub
		return hallDao.queryAllHall();
	}

	@Override
	public Hall queryHallById(int hId) {
		// TODO Auto-generated method stub
		return hallDao.queryHallById(hId);
	}

	@Override
	public List<Hall> queryAllHallcId(int cId) {
		// TODO Auto-generated method stub
		return hallDao.queryAllHallcId(cId);
	}

}
