package com.example.movie_software.Controller;

import com.example.movie_software.Model.Director;
import com.example.movie_software.Model.Movie;
import com.example.movie_software.Service.DirecterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/directer/")
@RequiredArgsConstructor
public class DirectorController {


   private final DirecterService directerService;


    @GetMapping("/getdirecter")
    public ResponseEntity GetDirecter( ){
        List<Director> directors= directerService.GetAllDirecter();
        return ResponseEntity.status(200).body(directors);
    }
    @PostMapping("/add")
    public ResponseEntity AddDirecter(@Valid @RequestBody Director directer){
        directerService.AddMovieDirecter(directer);
        return ResponseEntity.status(200).body("directer added ");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity UpdateDircter(@PathVariable Integer id , @Valid @RequestBody Director directer) {
        directerService.updateDirecter(directer,id);
        return ResponseEntity.status(200).body("update directer ");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteDirecter(@PathVariable Integer id) {
        directerService.DeleteDirecter(id);
        return ResponseEntity.status(200).body("deleted directer ");
    }


}
