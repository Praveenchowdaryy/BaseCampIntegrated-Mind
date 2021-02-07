package com.mind.Integrated13;

import java.util.Scanner;

public class MovieApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Movie movies[] = {};
		int choice;
		do {
			System.out.println(
					"1.Add Movie Details\n2.Display Movie details\n3.Delete Movie details\n4.Exit\n\nEnter your choice : ");
			choice = intValidate();
			switch (choice) {
			case 1: {
				movies = addMovies(movies);
			}
				break;
			case 2: {
				displayMovies(movies);
			}
				break;
			case 3: {
				deleteMovie(movies);
			}
				break;
			case 4: {
				System.out.println("Thank you!");
			}
				break;
			default: {
				System.out.println("Invalid input!");
			}
			}

		} while (choice != 4);

	}

	private static void deleteMovie(Movie[] movies) {
		display(movies);
		System.out.println("Enter the name of the Movie : ");
		String name = sc.next();
		deleteMovie(name, movies);
	}

	private static void deleteMovie(String name, Movie[] movies) {
		for (int i = 0; i < movies.length; i++) {
			if (movies[i].getName().compareToIgnoreCase(name) == 0) {
				System.out.println("Movie Name : " + movies[i].getName());
				System.out.println("Movie Rating : " + movies[i].getRating());
				System.out.println("Movie Language : " + movies[i].getLanguage());
				System.out.println("Movie Genre : " + movies[i].getGenre());
				System.out.println("Movie Cast : ");
				for (int j = 0; j < movies[i].getCast().length; j++) {
					System.out.print(movies[i].getCast()[j] + "  ");
				}
				movies[i].setMoviePresent(false);
				System.out.println("Movie Deleted Successfully ! ");

			}
		}

	}

	private static void displayMovies(Movie[] movies) {
		int choice;
		do {
			System.out.println(
					"1.Sort By Id\n2.Sorted by rating\n3. Search Movie By name\n4.Search movie by language\n5.Search movie by cast\n\n6.Exit\n\nEnter your choice : ");
			choice = intValidate();
			switch (choice) {
			case 1: {
				sortById(movies);
			}
				break;
			case 2: {
				sortByRating(movies);
			}
				break;
			case 3: {
				SearchByMovieName(movies);
			}
				break;
			case 4: {
				searchByMovieLanguage(movies);
			}
				break;
			case 5: {
				searchByCast(movies);
			}
				break;
			case 6: {
				System.out.println("Thank you!");
			}
				break;
			default: {
				System.out.println("Invalid input!");
			}
			}

		} while (choice != 6);
	}

	private static void searchByCast(Movie[] movies) {
		System.out.println("Enter Cast Name To search the movie : ");
		String name = sc.next();
		castFound(movies, name);
		System.out.println("-------------------------------");

	}

	private static void castFound(Movie[] movies, String name) {
		for (int i = 0; i < movies.length; i++) {
			for (int j = 0; j < movies[i].getCast().length; j++) {
				if (movies[i].getCast()[j].compareToIgnoreCase(name) == 0) {
					System.out.println("Movie Name : " + movies[i].getName());
					System.out.println("Movie Rating : " + movies[i].getRating());
					System.out.println("Movie Language : " + movies[i].getLanguage());
					System.out.println("Movie Genre : " + movies[i].getGenre());
				}
			}

		}

	}

	private static void searchByMovieLanguage(Movie[] movies) {
		System.out.println("Enter Movie Language To search the movie : ");
		String language = sc.next();
		if (languageFound(movies, language)) {
			System.out.println("-------------------------------");
		} else {
			System.out.println("Language not found !");
		}

	}

	private static boolean languageFound(Movie[] movies, String language) {
		for (int i = 0; i < movies.length; i++) {
			if (movies[i].getLanguage().compareToIgnoreCase(language) == 0) {
				System.out.println("Movie Name : " + movies[i].getName());
				System.out.println("Movie Rating : " + movies[i].getRating());
				System.out.println("Movie Language : " + movies[i].getLanguage());
				System.out.println("Movie Genre : " + movies[i].getGenre());
				System.out.println("Movie Cast : ");
				for (int j = 0; j < movies[i].getCast().length; j++) {
					System.out.print(movies[i].getCast()[j] + "  ");
				}
				return true;
			}
		}
		return false;
	}

	private static void SearchByMovieName(Movie[] movies) {
		display(movies);
		System.out.println("Enter Movie Name To search the movie : ");
		String name = sc.next();
		if (movieFound(movies, name)) {
			System.out.println("-------------------------------");
		} else {
			System.out.println("Movie not found !");
		}

	}

	private static boolean movieFound(Movie[] movies, String name) {
		for (int i = 0; i < movies.length; i++) {
			if (movies[i].getName().compareToIgnoreCase(name) == 0) {
				System.out.println("Movie Name : " + movies[i].getName());
				System.out.println("Movie Rating : " + movies[i].getRating());
				System.out.println("Movie Language : " + movies[i].getLanguage());
				System.out.println("Movie Genre : " + movies[i].getGenre());
				System.out.println("Movie Cast : ");
				for (int j = 0; j < movies[i].getCast().length; j++) {
					System.out.print(movies[i].getCast()[j] + "  ");
				}
				return true;
			}
		}
		return false;
	}

	private static void display(Movie[] movies) {
		for (int i = 0; i < movies.length; i++) {
			System.out.println((i + 1) + "." + movies[i].getName());
		}

	}

	private static void sortByRating(Movie[] movies) {
		Movie[] sorted = insertionSortRating(movies);
		System.out.println("Rating\t\tMovieName\t\tID");
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].getRating() + "\t\t" + sorted[i].getName() + "\t\t" + sorted[i].getId());
		}
	}

	private static Movie[] insertionSortRating(Movie[] movies) {
		for (int i = 1; i < movies.length; i++) {
			Movie key = movies[i];
			int j = i - 1;
			while (j >= 0 && movies[j].getRating() > key.getRating()) {
				movies[j + 1] = movies[j];
				j = j - 1;
			}
			movies[j + 1] = key;
		}
		return movies;
	}

	private static void sortById(Movie[] movies) {
		Movie[] sorted = insertionSort(movies);
		System.out.println("ID\t\tMovieName\t\tRating");
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].getId() + "\t\t" + sorted[i].getName() + "\t\t" + sorted[i].getRating());
		}
	}

	private static Movie[] insertionSort(Movie[] movies) {
		for (int i = 1; i < movies.length; i++) {
			Movie key = movies[i];
			int j = i - 1;
			while (j >= 0 && movies[j].getId() > key.getId()) {
				movies[j + 1] = movies[j];
				j = j - 1;
			}
			movies[j + 1] = key;
		}
		return movies;
	}

	private static Movie[] addMovies(Movie[] movies) {
		System.out.println("Enter movie ID : ");
		int id = intValidate();
		System.out.println("Enter movie Name : ");
		String name = sc.next();
		System.out.println("Enter movie Language : ");
		String language = sc.next();
		System.out.println("Enter movie Rating : ");
		float rating = floatValidate();
		System.out.println("Enter movie Genre");
		String genre = sc.next();
		String[] cast = getCast(movies);
		boolean isPresent = true;
		movies = addMovie(id, name, language, genre, rating, cast, isPresent, movies);
		return movies;
	}

	private static Movie[] addMovie(int id, String name, String language, String genre, float rating, String[] cast,
			boolean isPresent, Movie[] movies) {
		Movie res[] = new Movie[movies.length + 1];
		for (int i = 0; i < movies.length; i++) {
			res[i] = movies[i];
		}
		res[movies.length] = new Movie(id, name, language, genre, rating, cast, isPresent);
		return res;
	}

	private static String[] getCast(Movie[] movies) {
		String[] cast = new String[5];
		System.out.println("Enter the top 5 cast details of the movie : ");
		for (int i = 0; i < cast.length; i++) {
			System.out.println("Enter Cast " + (i + 1) + " Name : ");
			cast[i] = sc.next();
		}
		return cast;
	}

	private static int intValidate() {

		int data = 0;
		boolean validation = false;
		while (validation == false) {
			if (sc.hasNextInt()) {
				data = sc.nextInt();
				validation = true;
			} else if (!sc.hasNextInt()) {
				System.out.println("you didn't type an integer value ! please type an integer");
				sc.next();
			}
		}
		return data;
	}

	private static float floatValidate() {

		float data = 0;
		boolean validation = false;
		while (validation == false) {
			if (sc.hasNextFloat()) {
				data = sc.nextFloat();
				validation = true;
			} else if (!sc.hasNextFloat()) {
				System.out.println("you didn't type an integer value ! please type an integer");
				sc.next();
			}
		}
		return data;
	}
}

