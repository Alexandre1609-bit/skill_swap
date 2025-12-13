package com.alex.skill_swap.model;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

     private String name;
     private String password;
     private String email;
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     private Integer balance;

     public User() {}

     public User(String name, String password, String email, Integer id, Integer balance) {
          this.name = name;
          this.password = password;
          this.email = email;
          this.id = id;
          this.balance = balance;

     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public Integer getBalance() {
          return balance;
     }

     public void setBalance(Integer balance) {
          this.balance = balance;
     }

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }
}
