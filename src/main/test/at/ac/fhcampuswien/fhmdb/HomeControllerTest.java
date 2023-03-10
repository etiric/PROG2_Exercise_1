package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    private static HomeController homeController;
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
    void movies_are_sorted_correctly_with_current_sortState_none_then_ascending () {
        //GIVEN
        homeController.initializeState();
       // homeController.sortState = SortState.NONE;

        //WHEN
        //homeController.sortMovies();

        //THEN
        List<Movie> expected = Arrays.asList();
        //Filme hinzufügen mit Name, Titel und Genre

        assertEquals(expected, homeController.observableMovies);

    }
}