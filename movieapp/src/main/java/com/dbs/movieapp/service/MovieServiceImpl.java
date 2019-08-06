package com.dbs.movieapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dbs.movieapp.dao.MoviesDAO;
import com.dbs.movieapp.model.Movie;

@Service
public class MovieServiceImpl implements MovieService{
	private MoviesDAO movieDAO;
	
	@Autowired
    public MovieServiceImpl(@Qualifier("h2Dao") MoviesDAO movieDAO){
        this.movieDAO = movieDAO;
    }

	public Movie saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieDAO.save(movie);
	}

	public List<Movie> listAll() {
		// TODO Auto-generated method stub
		return movieDAO.findAll();
	}

	public Movie findById(long id) {
		// TODO Auto-generated method stub
		return movieDAO.findById(id);
	}

	public void deleteMovie(long id) {
		 this.movieDAO.deleteMovie(id);
	}

}