package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping ("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){

       movieService.addMovie(movie);

        return new ResponseEntity<>("Successs", HttpStatus.CREATED);
    }

    @PostMapping ("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){

        movieService.addDirector(director);

        return new ResponseEntity<>("Successs", HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName, @RequestParam String directorName){
        movieService.addMovieDirectorPair(movieName, directorName);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movieDetails = movieService.findMovieByName(name);

        return new ResponseEntity<>(movieDetails, HttpStatus.OK);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director directorDetails = movieService.findDirectorByName(name);
        return new ResponseEntity<>(directorDetails, HttpStatus.OK);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> moviesList = movieService.findMoviesByDirectorName(director);
        return new ResponseEntity<>(moviesList, HttpStatus.OK);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies = movieService.allMoviesList();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam(value = "director") String directorName){
        movieService.deleteByDirectorName(directorName);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirector();
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }





}
