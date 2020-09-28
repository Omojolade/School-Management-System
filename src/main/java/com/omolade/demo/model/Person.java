package com.omolade.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name= "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String email;
    private String username;
    private String password;
//    private String contactNo;
    private String role;
    @ManyToMany (mappedBy = "persons")
    List<Course> courseList = new ArrayList<>();
    private String matricNo;
    private String firstName;
    private String lastName;
//    private String age;
    private String title;
    private String middleName;
    private String religion;
    private Date DoB;
    private String Nationality;
    private String programme;
    private String permanentAddress;
}
