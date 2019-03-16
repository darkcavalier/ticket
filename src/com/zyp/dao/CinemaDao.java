package com.zyp.dao;

import java.util.List;

import com.zyp.entity.Cinema;


public interface CinemaDao {
	public boolean addCinema(Cinema cinema);
	public boolean delCinema(int cId);
	public boolean updateCinema(Cinema cinema);
	public List<Cinema> queryAllCinema();
	public Cinema queryCinemaById(int cId);
	public List<Cinema> queryCinemaByCinemaName(String cName);
	public List<Cinema> queryCinemaByCinemaAddress(String cAddress);
	public List<Cinema> queryCinemaByCinemaNameAndCinemaAddress(String cName,String cAddress);
	public Cinema queryCinema(Cinema cinema);
}
