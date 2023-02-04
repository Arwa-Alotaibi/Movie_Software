package com.example.movie_software.Service;

import com.example.movie_software.Exception.ApiException;
import com.example.movie_software.Model.Movie;
import com.example.movie_software.Repository.DirecterRepository;
import com.example.movie_software.Repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.movie_software.Model.Director;
@Service
public class MovieService {
    private MovieRepository movieRepository;
    private DirecterRepository directerRepository;

    public MovieService(MovieRepository movieRepository,DirecterRepository directerRepository){
        this.movieRepository=movieRepository;
        this.directerRepository=directerRepository;
    }

    //Movie CRUD
    public List <Movie> GetAllMovie(){
       return movieRepository.findAll();
    }

    public void AddMoviee(Movie movie){
        movieRepository.save(movie);
    }

    public void UpdateMovie(Movie movie,Integer id){
        Movie oldMovie = movieRepository.findMovieById( id);
        if(oldMovie==null){
            throw new ApiException("id not found!");
        }
        //    //Movie Class : ID, name , genre , rating , duration , directorID
        oldMovie.setName(movie.getName());
        oldMovie.setGenre(movie.getGenre());
        oldMovie.setRating(movie.getRating());
        oldMovie.setDuration(movie.getDuration());
        oldMovie.setDirectorID(movie.getDirectorID());
        movieRepository.save(oldMovie);
    }

    public void DeleteMovie(Integer id){
        Movie moviedelete = movieRepository.findMovieById(id);
        if(moviedelete==null){
            throw new ApiException("id not found!");
        }
        movieRepository.delete(moviedelete);
    }

    //search for a specific movie by title
    public Movie  MovieSearch(String name){
        Movie moviesearch = movieRepository.findMovieByName(name);
        if(moviesearch==null){
            throw new ApiException("title not found!");
        }
        return moviesearch;
    }

    // returns all movies by a specific genre
    public List<Movie> GetAllbyGenre(String genre){
        List<Movie> movies = movieRepository.findAllByGenre(genre);
        if(movies.isEmpty()){
            throw new ApiException("genre not found");
        }
        return movies;
    }

    // returns all movies above that rate
    public  List<Movie> AllMoviesRating(int rating){
        List<Movie> movies = movieRepository.findAllByRatingGreaterThanEqual(rating);
        if(movies.isEmpty()){
            throw new ApiException("rating not found");
        }
        return movies;
    }
   // takes movie name and return the rate of the movie
    public int ReturnRate(String name){
        Movie movies= movieRepository.findMovieByName(name);
        if(movies==null){
            throw new ApiException("rate not found");
        }
        return  movies.getRating();
    }

    // takes movie name and return the duration of the movie
    public int ReturnDuration(String name){
        Movie movie= movieRepository.findMovieByName(name);
        if(movie==null){
            throw new ApiException("name not found");
        }
        return movie.getDuration();
    }

    // takes movie name and return the director name
    public String ReturnDirecterName(String name){
        Movie movie = movieRepository.findMovieByName(name);
        Director director =directerRepository.findDirectorById(movie.getDirectorID());
        if(movie==null){
            throw new ApiException("name not found or id not found");
        }
        return director.getName();
    }


      //list movies to a specific director
    public List <Movie> ListMovieSpecificDirector(Integer id){
        List<Movie> movie =movieRepository.findAllByDirectorID(id);
        if(movie.isEmpty()){
            throw new ApiException("list  not found");
        }
        return movie;
    }










}
