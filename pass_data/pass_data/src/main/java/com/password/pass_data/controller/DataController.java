package com.password.pass_data.controller;

import com.password.pass_data.model.password_list;
import com.password.pass_data.service.passwordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/cypher/v1/password-lists")
@CrossOrigin(origins = "http://localhost:5500")
public class DataController {
    @Qualifier("passwordserviceimpl")
    @Autowired
    private passwordService passservice;



    // API for getting the list of all password for that particular person
    @CrossOrigin(origins = {"http://localhost:5500"})
    @GetMapping("/{id}")
    public ResponseEntity<List<password_list>> getPasswordListById(@PathVariable int id) throws Exception {
        List<password_list> passwordList = passservice.getPasswordListById(id);
        return ResponseEntity.ok(passwordList);
    }


    // If user wants to delete all the passwords at once
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePasswordListById(@PathVariable int id) throws Exception {
        passservice.deletePasswordListById(id);
        return ResponseEntity.ok("Password list deleted successfully");
    }


    // If user wants to delete a particular row by giving all the details
    @DeleteMapping("/by-name-website-password")
    public ResponseEntity<String> deletePasswordListByNameWebsitePassword(@RequestBody password_list passwordList) throws Exception {
        passservice.deletePasswordListByNameWebsitePassword(passwordList);
        return ResponseEntity.ok("Password list deleted successfully");
    }

}
