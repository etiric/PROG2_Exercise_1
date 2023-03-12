package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    private static Movie movie;

    @Test
    void test_if_getGenreList_return_list_of_all_genres() {
        List<Genre> expected = Arrays.asList(
                Genre.ACTION,
                Genre.ADVENTURE,
                Genre.ANIMATION,
                Genre.BIOGRAPHY,
                Genre.COMEDY,
                Genre.CRIME,
                Genre.DRAMA,
                Genre.DOCUMENTARY,
                Genre.FAMILY,
                Genre.FANTASY,
                Genre.HISTORY,
                Genre.HORROR,
                Genre.MUSICAL,
                Genre.MYSTERY,
                Genre.ROMANCE,
                Genre.SCIENCE_FICTION,
                Genre.SPORT,
                Genre.THRILLER,
                Genre.WAR,
                Genre.WESTERN
        );
       List<Genre> actual = Movie.getGenreList();

       assertEquals(expected, actual);
    }

    @Test
    void test_if_initializeMovies_returns_list_of_movies () {
        List<Movie> expected = new ArrayList<>();

        Movie movie1 = new Movie("Movie 1", "Description 1", List.of(Genre.ACTION, Genre.ADVENTURE));
        Movie movie2 = new Movie("Movie 2", "Description 2", List.of(Genre.CRIME, Genre.BIOGRAPHY));
        Movie movie3 = new Movie("Movie 3", "Description 3", List.of(Genre.DRAMA));
        Movie movie4 = new Movie("Movie 4", "Description 4", List.of(Genre.FANTASY, Genre.ACTION));
        Movie movie5 = new Movie("X_Movie 5", "Z_Description 5", List.of(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA));

        expected.add(movie1);
        expected.add(movie2);
        expected.add(movie3);
        expected.add(movie4);
        expected.add(movie5);



        List<Movie> actual = Movie.initializeMovies();

        assertEquals(expected.size(), actual.size());
    }

    @Test
    void test_if_getTitle_returns_title_of_movie () {
        List<Movie> movies = new ArrayList<>();
        movies.addAll(Movie.initializeMovies());

        String expected = "Movie 1";

        String actual = movies.get(0).getTitle();

        assertEquals(expected, actual);
    }

    @Test
    void test_if_getDescription_returns_description_of_movie () {
        List<Movie> movies = new ArrayList<>();
        movies.addAll(Movie.initializeMovies());

        String expected = "Description 1";

        String actual = movies.get(0).getDescription();

        assertEquals(expected, actual);
    }

    @Test
    void test_if_getGenre_returns_genre_of_movie () {
        List<Movie> movies = new ArrayList<>();
        movies.addAll(Movie.initializeMovies());

        List<Genre> expected = List.of(Genre.ACTION, Genre.ADVENTURE);

        List<Genre> actual = movies.get(0).getGenres();

        assertEquals(expected, actual);
    }

    @Test
    void test_if_Movie_constructor_creates_movie () {
        Movie movie = new Movie("Movie 1", "Description 1", List.of(Genre.ACTION, Genre.ADVENTURE));

        String expected = movie.getTitle() + ", " + movie.getDescription() + ", " + movie.getGenres();

        String actual = Movie.initializeMovies().get(0).getTitle() + ", " + Movie.initializeMovies().get(0).getDescription() + ", " +
                Movie.initializeMovies().get(0).getGenres();

        assertEquals(expected, actual);
    }



}