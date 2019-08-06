package com.dbs.movieapp.model;

public class Movie {
	private long id;
	private String name;
	private int rating;
	private int duration;
	public long getId() {
		return id;
	}
	
	public Movie(long id, String name, int rating, int duration) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.duration = duration;
	}


	public Movie(long id, String name, int duration) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
	}


	public String getName() {
		return name;
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public int getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return " [id=" + id + ", name=" + name + ", "
				+ "rating=" + rating + ", duration=" + duration + "]";
	}
	
	
}