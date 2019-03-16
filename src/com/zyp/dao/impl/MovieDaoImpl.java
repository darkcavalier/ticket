package com.zyp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.zyp.dao.MovieDao;
import com.zyp.entity.Movie;


public class MovieDaoImpl extends BaseDao implements MovieDao {

	@Override
	public boolean addMovie(Movie movie) {
		// TODO Auto-generated method stub
		if(movie==null) {
			System.out.println("are you kiding me?");
			return false;
		}
		String sql="insert into movie (mName,mlanguage,mlocality,mPicaddress,mDetail,mDuration,mType,mGrade) values(?,?,?,?,?,?,?,?)";
		List<Object> params1 = new ArrayList<Object>();
		params1.add(movie.getmName());
		params1.add(movie.getMlanguage());
		params1.add(movie.getMlocality());
		params1.add(movie.getmPicaddress());
		params1.add(movie.getmDetail());
		params1.add(movie.getmDuration());
		params1.add(movie.getmType());
		params1.add(movie.getmGrade());
		return operUpdate(sql, params1);
	}

	@Override
	public boolean delMovie(int mid) {
		// TODO Auto-generated method stub
		String sql="delete from movie where mId="+mid;
		return operUpdate(sql, null);
	}

	@Override
	public boolean updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		String sql="update movie set mName=?,mlanguage=?,mlocality=?,mPicaddress=?,mDetail=?,"
				+ "mDuration=?,mType=?,mGrade=? where mId=?";
		List<Object> params1 = new ArrayList<Object>();
		params1.add(movie.getmName());
		params1.add(movie.getMlanguage());
		params1.add(movie.getMlocality());
		params1.add(movie.getmPicaddress());
		params1.add(movie.getmDetail());
		params1.add(movie.getmDuration());
		params1.add(movie.getmType());
		params1.add(movie.getmGrade());
		params1.add(movie.getmId());
		return operUpdate(sql, params1);						
	}

	@Override
	public List<Movie> queryAllMovie() {
		// TODO Auto-generated method stub
		String sql="select * from movie";
		List<Movie> list=null;
		try {
			list = operQuery(sql, null,Movie.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Movie queryMovieById(int mId) {
		// TODO Auto-generated method stub
		String sql ="select *from movie where mId="+mId;		
		List<Movie> list = null;
		try {
			list = operQuery(sql,null,Movie.class);			
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
	public List<Movie> OrderMovieTen() {
		// TODO Auto-generated method stub
		String sql = "select * from movie order by mGrade desc limit 10 ";
		List <Movie> list=null;
		
		try {
			list = operQuery(sql, null,Movie.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Movie> queryMovieByType(String mType) {
		// TODO Auto-generated method stub
		String type="'";
		for(int i=0;i<mType.length();i++) {
			type+=mType.charAt(i);
		}
		type+="'";
		String sql ="select * from movie where mType="+type;
		
		List <Movie> list=null;
		try {
			list = operQuery(sql, null,Movie.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Movie> queryMovieBymovieName(String mName) {
		// TODO Auto-generated method stub
		String name="'%";
		for(int i = 0; i < mName.length(); i++) {
			name += mName.charAt(i)+"%";
		}
		name += "'";
		String sql="select * from movie where mName like"+name;
		List<Movie> list=null;
		try {
			list = operQuery(sql,null,Movie.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
		
	}

	@Override
	public Movie queryMovie(Movie movie) {
		// TODO Auto-generated method stub
		String sql = "select * from movie where mName=? and mlanguage=? and mlocality=? and mPicaddress=? and mDetail=? "
				+ "and mDuration=? and mType=? and mGrade=?";
		List<Object> params = new ArrayList<Object>();
		params.add(movie.getmName());
		params.add(movie.getMlanguage());
		params.add(movie.getMlocality());
		params.add(movie.getmPicaddress());
		params.add(movie.getmDetail());
		params.add(movie.getmDuration());
		params.add(movie.getmType());
		params.add(movie.getmGrade());
		List<Movie> list = null;
		try {
			list = operQuery(sql,params,Movie.class);			
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
	public List<Movie> queryMovieByTypeandName(String mType, String mName) {
		// TODO Auto-generated method stub
		String name="'%";
		String type="'";
		for(int i=0;i<mType.length();i++) {
			type+=mType.charAt(i);
		}
		for(int i = 0; i < mName.length(); i++) {
			name += mName.charAt(i)+"%";
		}
		name += "'";
		type +="'";		
		String sql="select * from movie where mType ="+type+"and mName like"+name;
		List<Movie> list=null;
		try {
			list = operQuery(sql,null,Movie.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Movie queryMovieByName(String mName) {
		// TODO Auto-generated method stub
		String name="'";
		for(int i=0;i<mName.length();i++) {
			name+=mName.charAt(i);
		}
		name+="'";
		String sql ="select * from movie where mName="+name;
		
		List <Movie> list=null;
		try {
			list = operQuery(sql,null,Movie.class);			
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
