package com.example.movie_software.Controller;


import com.example.movie_software.Service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.movie_software.Model.Movie;
import java.util.List;
@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService=movieService;
    }
    @GetMapping("/getmovie")
    public ResponseEntity GetMovie( ){
        List<Movie> movies= movieService.GetAllMovie();
         return ResponseEntity.status(200).body(movies);
    }
    @PostMapping("/add")
    public ResponseEntity AddMovie(@Valid @RequestBody Movie movie){
        movieService.AddMoviee(movie);
        return ResponseEntity.status(200).body("movie added ");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity UpdateMovie(@PathVariable Integer id , @Valid @RequestBody Movie movie) {
        movieService.UpdateMovie(movie, id);
        return ResponseEntity.status(200).body("update movie ");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteMovie(@PathVariable Integer id) {
        movieService.DeleteMovie(id);
        return ResponseEntity.status(200).body("deleted movie ");
    }
    //Create endpoint that search for a specific movie by title
    @GetMapping("/search/{name}")
    public ResponseEntity Search(@PathVariable String name){
        Movie movie = movieService.MovieSearch(name);
        return ResponseEntity.status(200).body(movie);
    }

      //Create endpoint that returns all movies by a specific genre
    @GetMapping("/movies/{genre}")
    public ResponseEntity GetAllMoviesGenre(@PathVariable String genre){
        List <Movie> movies = movieService.GetAllbyGenre(genre);
        return ResponseEntity.status(200).body(movies);
    }

    //Create endpoint that returns all movies above that rate
    @GetMapping("/rate/{rating}")
    public ResponseEntity GetAllbyRating(@PathVariable int rating){
        List<Movie> movies = movieService.AllMoviesRating(rating);
        return ResponseEntity.status(200).body(movies);
    }
      // Create endpoint that takes movie name and return the rate of the movie
      @GetMapping("/name/{name}")
      public ResponseEntity GetRate(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.ReturnRate(name));
    }
    //Create endpoint that takes movie name and return the duration of the movie
    @GetMapping("/duration/{name}")
    public ResponseEntity GetDuration(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.ReturnDuration(name));
    }

   // Create endpoint that takes movie name and return the director name
    @GetMapping("/moviename/{name}")
    public ResponseEntity ReturnDirecterName(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.ReturnDirecterName(name));

    }

}
