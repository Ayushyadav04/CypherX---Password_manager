package com.password.Pass_login.UserController;

import com.password.Pass_login.DTO.LoginDTO;
import com.password.Pass_login.DTO.UserDTO;
import com.password.Pass_login.Service.UserService;
import com.password.Pass_login.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("cypher/v1")
public class UserController {
    @Autowired
    private UserService userService;


    // Sign up for user  === login in page
    @PostMapping(path = "/new_user")
    public int saveUser(@RequestBody UserDTO userDTO)
    {
        int id =userService.addUser(userDTO);
        return id;
    }

    // Sign in for user  === login in page
    @PostMapping(path = "/user_login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO)
    {
        LoginMessage loginResponse = userService.login(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
