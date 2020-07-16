package org.launchcode.javawebdevtechjobsauthentication.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {};

    public User(String aUsername, String aPassword) {
        this.username = aUsername;
        this.password = encoder.encode(aPassword);
    };


    public String getUsername() {
        return username;
    }

    public boolean matchingPassword(String password, String reEnteredPassword){
        if (password == reEnteredPassword) {
            return true;
        } else {
            return false;
        }
    }
}
