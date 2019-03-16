package com.zyp.service.impl;

import java.util.List;

import com.zyp.dao.CinemaDao;
import com.zyp.dao.impl.CinemaDaoImpl;
import com.zyp.entity.Cinema;
import com.zyp.service.CinemaService;

public class CinemaServiceImpl implements CinemaService {
	private CinemaDao cinemaDao;
   public CinemaServiceImpl() {
	// TODO Auto-generated constructor stub
	  cinemaDao=new CinemaDaoImpl();
   }
	@Override
	public int addCinema(Cinema cinema) {
		// TODO Auto-generated method stub
		Cinema c=cinemaDao.queryCinema(cinema);
		if(c==null) {
			boolean res_add =cinemaDao.addCinema(cinema);
			if (res_add) {
				return 1;//添加成功
			}else {
				return 2;//添加失败
			}
		}
		return 3;//添加失败-电影院已存在
	}

	@Override
	public boolean delCinema(int cid) {
		// TODO Auto-generated method stub
		return cinemaDao.delCinema(cid);
	}

	@Override
	public boolean updateCinema(Cinema cinema) {
		// TODO Auto-generated method stub
		return cinemaDao.updateCinema(cinema);
	}

	@Override
	public List<Cinema> queryAllCinema() {
		// TODO Auto-generated method stub
		return cinemaDao.queryAllCinema();
	}
	@Override
	public Cinema queryCinemaById(int cId) {
		// TODO Auto-generated method stub
		return cinemaDao.queryCinemaById(cId);
	}
	@Override
	public List<Cinema> queryCinemaByCinemaName(String cName) {
		// TODO Auto-generated method stub
		return cinemaDao.queryCinemaByCinemaName(cName);
	}
	@Override
	public List<Cinema> queryCinemaByCinemaAddress(String cAddress) {
		// TODO Auto-generated method stub
		return cinemaDao.queryCinemaByCinemaAddress(cAddress);
	}
	@Override
	public List<Cinema> queryCinemaByCinemaNameAndCinemaAddress(String cName, String cAddress) {
		// TODO Auto-generated method stub
		return cinemaDao.queryCinemaByCinemaNameAndCinemaAddress(cName, cAddress);
	}

}
