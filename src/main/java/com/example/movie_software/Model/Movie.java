package com.example.movie_software.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.lang.ref.Reference;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Movie {

    //Movie Class : ID, name , genre , rating , duration , directorID


//    Cannot be null
//    Length more than 3
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(columnDefinition = "int not null")
    @Min(value = 3)
    private Integer id;


//    Cannot be null
//    Length more than 2
    @NotEmpty(message = "cannot be null")
    @Size(min=2 , message = "length more than2")
    @Column(columnDefinition = "varchar(22) not null")
    private String name;

//    genre :
//    Cannot be null
//    Validation (Drama|Action|Comedy)

    @NotEmpty(message = "cannot be null")
    @Pattern(regexp = "Drama|Action|Comedy")
    @Column(columnDefinition = "varchar(20) not null check (genre='Drama' or genre='Action' or genre='Comedy') " )
    private String genre;

//    rating :
//    Cannot be null
//    I must be between 1 - 5
    @NotNull(message = "cannot be null")
    @Min(value = 1  ,message ="must be between 1 - 5")
    @Max(value = 5)
    @Column(columnDefinition = "int not null check (rating >1 and rating <=5 ) " )
    private int rating ;

//    duration :
//    Cannot be null
//    It must be more than 60
    @NotNull(message = "cannot be null")
    @Min(value = 60)
    @Column(columnDefinition = "int not null check (duration >=60) " )
    private int duration ;

    @Column(columnDefinition = "int not null  " )
    private int directorID;





}
