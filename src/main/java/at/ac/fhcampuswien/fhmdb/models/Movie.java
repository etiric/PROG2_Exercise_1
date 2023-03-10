package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.HomeController;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    static List<Genre> genres = new ArrayList<>();
    List<Genre> genre;

    public Movie(String title, String description, List<Genre> genre) {
        this.title = title;
        this.description = description;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public static List<Genre> getGenreList() {
        genres.addAll(List.of(Genre.values()));
        return genres;
    }

    public List<Genre> getGenres() {
        return genre;
    }

    public static List<Movie> initializeMovies() {

        List<Movie> movies = new ArrayList<>();

        Movie movie1 = new Movie("Movie 1", "Description 1", List.of(Genre.ACTION, Genre.ADVENTURE));
        Movie movie2 = new Movie("Movie 2", "Description 2", List.of(Genre.CRIME, Genre.BIOGRAPHY));
        Movie movie3 = new Movie("Movie 3", "Description 3", List.of(Genre.DRAMA));
        Movie movie4 = new Movie("Movie 4", "Description 4", List.of(Genre.FANTASY, Genre.ACTION));
        Movie movie5 = new Movie("X_Movie 5", "Z_Description 5", List.of(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA));

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);

        return movies;
    }
}
