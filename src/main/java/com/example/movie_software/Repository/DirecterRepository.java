package com.example.movie_software.Repository;

import com.example.movie_software.Model.Director;
import com.example.movie_software.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirecterRepository extends JpaRepository<Director,Integer> {

    Director findDirectorById(Integer id);
    Director findAllById(Integer id);

    Director findDirectorByName(String name);




}
