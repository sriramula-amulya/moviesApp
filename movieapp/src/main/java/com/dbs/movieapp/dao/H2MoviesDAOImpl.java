package com.dbs.movieapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dbs.movieapp.model.Movie;

@Repository("h2Dao")
public class H2MoviesDAOImpl implements MoviesDAO{
    private JdbcTemplate jdbcTemplate;

    @Autowired
	public H2MoviesDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Movie save(Movie movie) {
		this.jdbcTemplate.execute("insert into movies values "
        		+ "("+movie.getId()+",'"+movie.getName()+"',"+
        		movie.getRating()+","+movie.getDuration()+")");
		System.out.println("\n********Inserted*********\n");
        return movie;
	}

	public Movie update(long empId, Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Movie> findAll() {
		List<Map<String, Object>> list=jdbcTemplate.queryForList("SELECT * from movies");
		List<Movie> results=new ArrayList<Movie>();
		for(int i=0;i<list.size();i++) {
			Movie movie=new Movie((Integer)list.get(i).get("id"),(String)list.get(i).get("name"),
								(Integer)list.get(i).get("rating"),(Integer)list.get(i).get("duration"));
			results.add(movie);
		}
		return results;
	}

	public Movie findById(long id) {
		Movie movie=null;
		try {
			Map<String, Object> map=jdbcTemplate.queryForMap("SELECT * from movies where id = ?", id);
			movie=new Movie((Integer)map.get("id"),(String)map.get("name"),
					(Integer)map.get("rating"),(Integer)map.get("duration"));
		} catch (Exception e) {
		   System.out.println("No data Found for given Id");
		}
		return movie;
	}

	public void deleteMovie(long id) {
		// TODO Auto-generated method stub
		int res=jdbcTemplate.update("DELETE FROM movies WHERE id= ?",id);
		if(res==0)
			System.out.println("Record Not Found");
		else System.out.println("Records Deleted :"+res);
	}

}
