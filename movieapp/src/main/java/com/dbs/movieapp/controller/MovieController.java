package com.dbs.movieapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbs.movieapp.model.Movie;
import com.dbs.movieapp.service.MovieService;

@Component
public class MovieController {
	private MovieService movieService;
	
	@Autowired
    public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}

	public Movie saveMovie(Movie movie){
        return this.movieService.saveMovie(movie);
    }


	public List<Movie> listAll(){
        return this.movieService.listAll();
    }

    public Movie findById(long id){
        return this.movieService.findById(id);
    }

    public void deleteMovie(long id){
        this.movieService.deleteMovie(id);
    }
}
