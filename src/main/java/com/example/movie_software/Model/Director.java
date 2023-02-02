package com.example.movie_software.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Director {

    //Director Class: ID, name
    //Cannot be null
    //Length more than 3

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(columnDefinition = "varchar(3) not null")
    private Integer Id;

//    Cannot be null
//    Length more than 2
    @NotEmpty(message = "cannot be null")
    @Size(min=2 , message = "length more than2")
    @Column(columnDefinition = "varchar(20) not null ")
    private String name;


}
