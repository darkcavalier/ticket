package com.zyp.service;

import java.util.List;

import com.zyp.entity.Movie;

public interface MovieService {
	public int addMovie(Movie movie);
    public boolean delMovie(int mid);
    public boolean updateMovie(Movie movie);
    public List<Movie> queryAllMovie();
    public List<Movie> OrderMovieTen();
    public Movie queryMovieById(int mId);//根据mid获取M
    public Movie queryMovie(Movie movie);
    public List<Movie> queryMovieByType(String mType);
    public List<Movie> queryMovieBymovieName(String mName);//根据电影名称模糊查询
    public List<Movie> queryMovieByTypeandName(String mType,String mName);
    public Movie queryMovieByName(String mName);
}
