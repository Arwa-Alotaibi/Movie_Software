package com.example.movie_software.Repository;

import com.example.movie_software.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirecterRepository extends JpaRepository<Director,Integer> {

    Director findDirectorById(Integer id);
    Director findAllById(Integer id);

    Director findDirectorByName(String name);

}
