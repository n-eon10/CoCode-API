package com.afam.cocodeapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String username;
    private String email;
    private String password;

    //user profile attributes
    private String name;
    private String aboutUser;
    private String skills;

    public UserModel() {
    }

    public UserModel(Long id, String username, String email, String password, String name, String about_user, String aboutUser, String skills) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.aboutUser = aboutUser;

        this.skills = skills;
    }

    public UserModel(String username, String email, String password, String name, String about_user, String aboutUser, String skills) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.aboutUser = aboutUser;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAboutUser() {
        return aboutUser;
    }

    public void setAboutUser(String aboutUser) {
        this.aboutUser = aboutUser;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", aboutUser='" + aboutUser + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}
