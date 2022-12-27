package com.boutiques.server.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private  String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private int role;

    public User(){}

    public User(String firstName, String lastName, String password, String email, int role){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    @Override
    public  String toString(){
        return "Client{" +
                "id" + id +", name'" + lastName + firstName + '\'' + ", email = '" + email + '\'' + ", role = '" + role + '\'' + '}';
    }
}
