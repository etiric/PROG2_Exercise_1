package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.jfoenix.controls.JFXButton;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;


class HomeControllerTest {

    private static HomeController homeController;
    private static List <Movie> movies = Movie.initializeMovies();
    @BeforeAll
    static void init() {
       homeController = new HomeController();
       movies = Movie.initializeMovies();
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
        assertEquals(expected, Movie.getGenreList());
    }



    @Test
    void test_if_initializeMovies_creates_all_movies () {
        assertEquals(5, movies.size());
    }

    @Test
    void sort_movies_asc () {
       /* homeController.initializeState();

       homeController.sortBtn.setText("Sort (asc)");
        homeController.sortMovies();

        assertEquals();*/
    }

    @Test
    void sort_movies_desc() {

        HomeController controller = new HomeController();
        controller.initializeState();

        controller.sortBtn.setText("Sort (desc)");
        controller.sortMovies();
        List<Movie> expected;
    }

    @Test
    void filter_movies_when_text_field_is_not_null() {
    List<Movie> movies = new ArrayList<>();


        homeController.initializeState();
        TextField textField = homeController.searchField;

        textField.setText("X");

        homeController.filterMovies();
        movies.addAll(homeController.movieListView.getItems());

        List<Movie> expected = new ArrayList<>();
        expected.add(homeController.observableMovies.get(4));

        assertEquals(expected, movies);

    }

    @Test
    void filter_movies_when_genreComboBox_is_not_null() {
        List<Movie> movies = new ArrayList<>();
        ComboBox comboBox = homeController.genreComboBox;
        comboBox.setValue(Genre.ACTION);

    }

    @Test
    void filter_movies_when_text_field_and_genreComboBox_are_not_null () {

    }

    @Test
    void filter_movies_when_text_field_and_genreComboBox_are_both_null () {
    }

    @Test
    void remove_filter_method_removes_both_filter() {
        homeController.initializeState();
        homeController.removeFilter();
        String expected = "";

        homeController.searchField.getText();
        homeController.genreComboBox.getValue();

        assertEquals(expected, homeController.searchField.getText());

    }

}