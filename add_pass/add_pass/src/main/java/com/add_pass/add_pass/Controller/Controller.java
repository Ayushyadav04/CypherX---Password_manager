package com.add_pass.add_pass.Controller;

import com.add_pass.add_pass.Model.password_list;
import com.add_pass.add_pass.service.passwordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/add_paswords")
public class Controller {
    @Qualifier("passwordserviceimpl")
    @Autowired
    private passwordService passservice;


    @PostMapping 
    public ResponseEntity<String> postPasswordList(@RequestBody password_list passwordList) throws Exception {
        passservice.postPasswordList(passwordList);
        return ResponseEntity.ok("Password list posted successfully");
    }
}
