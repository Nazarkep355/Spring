package com.example.springfinalproject.Services;

import com.example.springfinalproject.Entity.User;
import com.example.springfinalproject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserService {
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    UserRepository userRepository;

    public boolean isUserWithEmailExists(String email){
        List<User> users = userRepository.findByEmail(email);
        return users.size()>0;
    }
    public void registerUser(@Valid User user){
        if(isUserWithEmailExists(user.getEmail()))
            throw new IllegalArgumentException("EmailInDB");
        user.setEnabled(true);
        user.setMoney(0);
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }
    public User getUserByEmail(String email){
        if (isUserWithEmailExists(email))
        return userRepository.findByEmail(email).get(0);
        else throw new IllegalArgumentException("NoUser");
    }

}
