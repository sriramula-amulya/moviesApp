package com.dbs.movieapp.dao;

import java.util.List;

import com.dbs.movieapp.model.Movie;

public interface MoviesDAO {

    Movie save(Movie movie);

    Movie update(long empId, Movie movie);

    List<Movie> findAll();

    Movie findById(long id);

    void deleteMovie(long id);
}
