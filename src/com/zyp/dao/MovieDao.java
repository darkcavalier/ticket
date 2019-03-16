package com.zyp.dao;

import java.util.List;

import com.zyp.entity.Movie;

public interface MovieDao {
	public boolean addMovie(Movie movie);
	public boolean delMovie(int mid);
	public boolean updateMovie(Movie movie);
	public List<Movie> queryAllMovie();
	public Movie queryMovieById(int mId);
	public List<Movie> OrderMovieTen();//评分最高的十部
	public List<Movie> queryMovieByType(String mType);
	public List<Movie> queryMovieBymovieName(String mName);//根据电影名称模糊查询
	public Movie queryMovie(Movie movie);
	public List<Movie> queryMovieByTypeandName(String mType,String mName);
	public Movie queryMovieByName(String mName);
}
