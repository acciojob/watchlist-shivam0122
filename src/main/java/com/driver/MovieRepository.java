package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieDetails;

    private HashMap<String, Director> directorDetails;

    private HashMap<String, List<String>> directorMoviePair;

    public MovieRepository() {
        this.movieDetails = new HashMap<>();
        this.directorDetails = new HashMap<>();
        this.directorMoviePair = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        movieDetails.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directorDetails.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        if(movieDetails.containsKey(movieName) && directorDetails.containsKey(directorName)){
            List<String> movieList = new ArrayList<>();
            if(directorMoviePair.containsKey(directorName)){
                movieList = directorMoviePair.get(directorName);
            }
            movieList.add(movieName);
            directorMoviePair.put(directorName, movieList);
        }
    }

    public Movie findMovieByName(String movieName) {
        return movieDetails.get(movieName);
    }

    public Director findDirectorByName(String directorName) {
        return directorDetails.get(directorName);
    }

    public List<String> findMoviesByDirectorName(String directorName) {
        List<String> moviesList = new ArrayList<>();
        if(directorMoviePair.containsKey(directorName)){
            moviesList = directorMoviePair.get(directorName);
        }
        return moviesList;
    }

    public List<String> allMoviesList() {
        List<String> movieList = new ArrayList<>();
        for(String movieName: movieDetails.keySet()){
            movieList.add(movieName);
        }

        return movieList;
    }

    public void deleteByDirectorName(String directorName) {
        if(directorDetails.containsKey(directorName)){
            directorDetails.remove(directorName);
        }
        List<String> movies = new ArrayList<>();
        if(directorMoviePair.containsKey(directorName)){
            movies = directorMoviePair.get(directorName);
            directorMoviePair.remove(directorName);
        }

        for(String movieName: movies){
            if(movieDetails.containsKey(movieName))
                movieDetails.remove(movieName);
        }
    }

    public void deleteAllDirector() {
        List<String> directorList = new ArrayList<>();
        for(String directorName: directorDetails.keySet()){
            directorList.add(directorName);
            directorDetails.remove(directorName);
        }

        HashSet<String> moviesSet = new HashSet<>();

        for(String directorName: directorList){
            if(directorMoviePair.containsKey(directorName)) {
                for(String movieName: directorMoviePair.get(directorName)){
                    moviesSet.add(movieName);
                }
                directorMoviePair.remove(directorName);
            }
        }

        for(String movie: moviesSet){
            if(movieDetails.containsKey(movie))
                movieDetails.remove(movie);
        }

    }
}
