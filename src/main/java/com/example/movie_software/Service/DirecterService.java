package com.example.movie_software.Service;

import com.example.movie_software.Exception.ApiException;
import com.example.movie_software.Model.Director;
import com.example.movie_software.Model.Movie;
import com.example.movie_software.Repository.DirecterRepository;
import com.example.movie_software.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DirecterService {
    //Director CRUD
    private final  MovieRepository movieRepository;

    private final DirecterRepository directerRepository;

    public List<Director> GetAllDirecter(){
        return directerRepository.findAll();
    }
    public void AddMovieDirecter(Director director){
        directerRepository.save(director);
    }
    public void  updateDirecter(Director director,Integer id){
        Director olddirecter= directerRepository.findDirectorById(id);
        if(olddirecter==null){
            throw new ApiException("id not found");
        }
        olddirecter.setName(director.getName());
        directerRepository.save(olddirecter);
    }
    public void DeleteDirecter(Integer id){
        Director directerdelete = directerRepository.findDirectorById(id);
        if(directerdelete==null){
            throw new ApiException("id not found!");
        }
        directerRepository.delete(directerdelete);
    }

    //list movies to a specific director
    public List <Movie> ListMovieSpecificDirector(Integer id){
        List<Movie> movie =movieRepository.findAllByDirectorID(id);
        if(movie.isEmpty()){
            throw new ApiException("id not found");
        }
        return movie;
    }





}
