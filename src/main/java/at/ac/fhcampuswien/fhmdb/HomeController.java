package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;
    @FXML
    public JFXButton noFilterBtn;
    @FXML
    public TextField searchField;
    @FXML
    public JFXListView movieListView;
    @FXML
    public JFXComboBox genreComboBox;
    @FXML
    public JFXButton sortBtn;
    public List<Movie> allMovies = Movie.initializeMovies();
    final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();// automatically updates corresponding UI elements when underlying data changes

    public void initializeState() {
        observableMovies.clear();
        observableMovies.addAll(allMovies);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        observableMovies.addAll(allMovies);// add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data
        genreComboBox.setPromptText("Filter by Genre");
        genreComboBox.getItems().addAll(Genre.values()); //Add ENUM Values to Combo Box

        searchBtn.setOnAction(actionEvent -> {
            filterMovies();
        });

        sortBtn.setOnAction(actionEvent -> {
            sortBtn.setText("Sort (asc)");
            sortMovies();
        });

        noFilterBtn.setOnAction(actionEvent -> {
            removeFilter();
        });

        searchField.setOnAction(actionEvent -> {
            filterMovies();
        });
    }

    ObservableList<Movie> movieList = FXCollections.observableArrayList();


    public void filterMovies() {

        if (genreComboBox.getValue() == null && searchField.getText().equals("")) { //No Filter picked

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Choose Filter");
            //Setting the content of the dialog
            alert.setContentText("Please choose a Filter!");
            alert.show();
            //movieList.setAll(observableMovies);
        } else if (searchField.getText().equals("") && genreComboBox.getValue() != null) { //Filter by Genre
            movieList.clear();
            for (int i = 0; i < observableMovies.size(); i++) {
                for (int j = 0; j < observableMovies.get(i).getGenres().size(); j++) {
                    if (observableMovies.get(i).getGenres().get(j).equals(genreComboBox.getValue())) {
                        movieList.add(observableMovies.get(i));
                    }
                }
            }
            movieListView.setItems(movieList);
            movieListView.setCellFactory(movieListView -> new MovieCell());

        } else if (!searchField.getText().equals("") && genreComboBox.getValue() == null) { //Filter by Text
            movieList.clear();
            for (int i = 0; i < observableMovies.size(); i++) {
                if (observableMovies.get(i).getTitle().toUpperCase().contains(searchField.getText().toUpperCase()) ||
                        observableMovies.get(i).getDescription().toUpperCase().contains(searchField.getText().toUpperCase())) {
                    movieList.add(observableMovies.get(i));
                }
            }
            movieListView.setItems(movieList);
            movieListView.setCellFactory(movieListView -> new MovieCell());

        } else if (!searchField.getText().equals("") && genreComboBox.getValue() != null) { //Filter by both
            movieList.clear();
            for (int i = 0; i < observableMovies.size(); i++) {
                for (int j = 0; j < observableMovies.get(i).getGenres().size(); j++) {
                    if (observableMovies.get(i).getGenres().get(j).equals(genreComboBox.getValue()) &&
                            (observableMovies.get(i).getTitle().toUpperCase().contains(searchField.getText().toUpperCase()) ||
                                    observableMovies.get(i).getDescription().toUpperCase().contains(searchField.getText().toUpperCase()))
                    ) {
                        movieList.add(observableMovies.get(i));
                    }
                }
            }
            movieListView.setItems(movieList);
            movieListView.setCellFactory(movieListView -> new MovieCell());
        }
    }

    public void removeFilter() {
        genreComboBox.setValue(null);
        searchField.setText("");
        movieListView.setItems(observableMovies);
    }

    public void sortMovies() {
        if (sortBtn.getText().equals("Sort (asc)")) {
            movieList.sort(Comparator.comparing(movie -> movie.getTitle()));
            observableMovies.sort(Comparator.comparing(movie -> movie.getTitle()));
            sortBtn.setText("Sort (desc)");
        } else if (sortBtn.getText().equals("Sort (desc)")) {
            movieList.sort(Comparator.comparing(Movie::getTitle).reversed());
            observableMovies.sort(Comparator.comparing(Movie::getTitle).reversed());
            sortBtn.setText("Sort (asc)");
        }
    }
}




