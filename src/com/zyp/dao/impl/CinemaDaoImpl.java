package com.zyp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.zyp.dao.CinemaDao;
import com.zyp.entity.Cinema;
import com.zyp.entity.Movie;
import com.zyp.entity.User;

public class CinemaDaoImpl extends BaseDao implements CinemaDao {

	@Override
	public boolean addCinema(Cinema cinema) {
		// TODO Auto-generated method stub
		if (cinema == null) {
			System.out.println("are you kiding me?");
			return false;
		}
		String sql="insert into cinema (cname,caddress) values(?,?)";
		List<Object> params1 = new ArrayList<Object>();
		params1.add(cinema.getCname());
		params1.add(cinema.getCaddress());
		
		return operUpdate(sql, params1);
	}

	@Override
	public boolean delCinema(int cId) {
		// TODO Auto-generated method stub
		String sql = "delete from cinema where cId=" + cId;
		return operUpdate(sql, null);
	}
   //根据id更新
	@Override
	public boolean updateCinema(Cinema cinema) {
		// TODO Auto-generated method stub
		String sql = "update cinema set cname=?,caddress=? where cId=?";
		List<Object> params1 = new ArrayList<Object>();
		params1.add(cinema.getCname());
		params1.add(cinema.getCaddress());
		params1.add(cinema.getCid());
		return operUpdate(sql, params1);
	}

	@Override
	public List<Cinema> queryAllCinema() {
		// TODO Auto-generated method stub
		String sql = "select * from cinema";
		List<Cinema> list=null;
		try {
			list = operQuery(sql, null, Cinema.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Cinema queryCinemaById(int cId) {
		// TODO Auto-generated method stub
		String sql ="select * from cinema where cId="+cId;
		
		List<Cinema> list=null;
		
		try {
			list = operQuery(sql, null,Cinema.class);
			if (list.size() == 0) {
				return null;
			} else {
				return list.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Cinema> queryCinemaByCinemaName(String cName) {
		// TODO Auto-generated method stub
		String name="'%";
		for(int i = 0; i < cName.length(); i++) {
			name += cName.charAt(i)+"%";
		}
		name+="'";
		String sql="select * from cinema where cName like"+name;
		List<Cinema> list=null;
		try {
			list = operQuery(sql,null,Cinema.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Cinema> queryCinemaByCinemaAddress(String cAddress) {
		// TODO Auto-generated method stub
		String address="'%";
		for(int i = 0; i < cAddress.length(); i++) {
			address += cAddress.charAt(i)+"%";
		}
		address+="'";
		String sql="select * from cinema where cAddress like"+address;
		List<Cinema> list=null;
		try {
			list = operQuery(sql,null,Cinema.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Cinema> queryCinemaByCinemaNameAndCinemaAddress(String cName, String cAddress) {
		// TODO Auto-generated method stub
		String address="'%";
		for(int i = 0; i < cAddress.length(); i++) {
			address += cAddress.charAt(i)+"%";
		}
		address+="'";
		String name="'%";
		for(int i = 0; i < cName.length(); i++) {
			name += cName.charAt(i)+"%";
		}
		name+="'";
		String sql="select * from cinema where cName like"+name+"and cAddress like"+address;
		List<Cinema> list=null;
		try {
			list = operQuery(sql,null,Cinema.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Cinema queryCinema(Cinema cinema) {
		// TODO Auto-generated method stub
		String sql = "select * from cinema where cName=? and cAddress=? ";
		List<Object> params = new ArrayList<Object>();
		params.add(cinema.getCname());
		params.add(cinema.getCaddress());
		List<Cinema> list=null;
		try {
			list = operQuery(sql,params,Cinema.class);			
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
