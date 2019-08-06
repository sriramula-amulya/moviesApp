package com.dbs.movieapp.service;

import java.util.List;

import com.dbs.movieapp.model.Movie;

public interface MovieService {
	
	   Movie saveMovie(Movie movie);

	   List<Movie> listAll();

	   Movie findById(long empId);

	   void deleteMovie(long empId);
}