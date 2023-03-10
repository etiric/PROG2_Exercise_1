package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.text.GapContent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    private static HomeController homeController;
    List <Movie> movies = Movie.initializeMovies();
    @BeforeAll
    static void init() {
       homeController = new HomeController();
    }

    @Test
    void movies_and_observable_Movies_are_equal() {
        //GIVEN
        homeController.initializeState();

        //WHEN & THEN
        assertEquals(homeController.allMovies, homeController.observableMovies);
    }

    @Test
    void test_if_list_of_genres_contains_every_genre () {
        assertEquals(20, Movie.getGenreList().size());
    }

    @Test
    void test_if_initializeMovies_creates_all_movies () {
        assertEquals(5, movies.size());
    }

    @Test
    void sort_movies_asc () {

        homeController.sortBtn.setText("Sort (asc)"); //Set sort Button asc;
        homeController.sortMovies(); //sort

        assertEquals(homeController.allMovies, homeController.observableMovies);
    }

    @Test
    void sort_movies_desc() {

    }

    @Test
    void filter_movies_when_text_field_is_not_null() {

    }

    @Test
    void filter_movies_when_genreComboBox_is_not_null() {

    }

    @Test
    void filter_movies_when_text_field_and_genreComboBox_are_not_null () {

    }

    @Test
    void filter_movies_when_text_field_and_genreComboBox_are_both_null () {

    }

    @Test
    void remove_filter_method_removes_both_filter() {

    }

}