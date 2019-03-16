package com.zyp.service;

import java.util.List;

import com.zyp.dao.CinemaDao;
import com.zyp.dao.impl.CinemaDaoImpl;
import com.zyp.entity.Cinema;

public interface CinemaService {
	public int addCinema(Cinema cinema);
	public boolean delCinema(int cid);
	public boolean updateCinema(Cinema cinema);
	public List<Cinema> queryAllCinema();
	public Cinema queryCinemaById(int cId);
	public List<Cinema> queryCinemaByCinemaName(String cName);
	public List<Cinema> queryCinemaByCinemaAddress(String cAddress);
	public List<Cinema> queryCinemaByCinemaNameAndCinemaAddress(String cName, String cAddress);
}
