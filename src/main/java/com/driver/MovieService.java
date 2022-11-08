package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public void addMovie(Movie movie) {

        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {

        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movieName, String directorName){
        movieRepository.addMovieDirectorPair(movieName, directorName);
    }

    public Movie findMovieByName(String movieName) {
        return movieRepository.findMovieByName(movieName);
    }

    public Director findDirectorByName(String directorName) {
        return movieRepository.findDirectorByName(directorName);
    }

    public List<String> findMoviesByDirectorName(String directorName) {
        return movieRepository.findMoviesByDirectorName(directorName);
    }

    public List<String> allMoviesList() {
        return movieRepository.allMoviesList();
    }

    public void deleteByDirectorName(String directorName) {
        movieRepository.deleteByDirectorName(directorName);
    }

    public void deleteAllDirector() {
        movieRepository.deleteAllDirector();
    }


}
