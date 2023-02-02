package com.example.movie_software.Repository;

import com.example.movie_software.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
   // search for a specific movie by title
    Movie findByName(String name);

    Movie findMovieById(Integer id);

    //returns all movies by a specific genre
    List<Movie> findAllByGenre(String genre);

    //returns all movies above that rate
    List<Movie> findAllByRatingGreaterThanEqual(int rating);

    List<Movie> findAllByDirectorID(int directorID);
    Movie findMovieByDirectorID(int directorID);




}
