package com.mind.Integrated13;

public class Movie {
	private int id;
	private String name;
	private float rating;
	private String language;
	private String genre;
	private String cast[] = new String[5];
	private boolean isMoviePresent;

	public Movie(int id, String name, String language, String genre, float rating, String[] cast, boolean isPresent) {
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.language = language;
		this.cast = cast;
		this.isMoviePresent = isPresent;
		this.genre = genre;
	}

	public boolean isMoviePresent() {
		return isMoviePresent;
	}

	public void setMoviePresent(boolean isMoviePresent) {
		this.isMoviePresent = isMoviePresent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String[] getCast() {
		return cast;
	}

	public void setCast(String[] cast) {
		this.cast = cast;
	}
}
