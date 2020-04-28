package net.javaguides.springboot.tutorial.controller;


import net.javaguides.springboot.tutorial.entity.User;
import net.javaguides.springboot.tutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class RestUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userRestList")
    public ResponseEntity<List<User>> getRestUserList() {
        return new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/userRest/{id}")
    public ResponseEntity<User> getRestUserById(@PathVariable long id) {
        return userRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/userRest/save")
    public ResponseEntity<Void> saveOrUpdateRestUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/userRest/update/{id}")
    public ResponseEntity<User> updateRestUser(@PathVariable("id") long id, @RequestBody User user) {

        Optional<User> updateUser = userRepository.findById(id);
        if (updateUser.isPresent()) {
            User newUser = updateUser.get();
            newUser.setName(user.getName());
            newUser.setSerName(user.getSerName());
            newUser.setAge(user.getAge());
            return new ResponseEntity<>(userRepository.save(newUser), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/userRest/delete/{id}")
    public ResponseEntity<Void> deleteRestUser(@PathVariable long id, User user) {
        userRepository.findById(id);
        userRepository.delete(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
