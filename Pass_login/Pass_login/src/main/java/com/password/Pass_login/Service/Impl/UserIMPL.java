package com.password.Pass_login.Service.Impl;

import com.password.Pass_login.DTO.LoginDTO;
import com.password.Pass_login.DTO.UserDTO;
import com.password.Pass_login.Entity.User;
import com.password.Pass_login.Repo.UserRepo;
import com.password.Pass_login.Service.UserService;
import com.password.Pass_login.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
@Service
public class UserIMPL implements UserService {
    @Autowired
    private UserRepo UserRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public int addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getUserid(),
                userDTO.getUsername(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );
        UserRepo.save(user);
        return user.getUserid();
    }

    public LoginMessage login(LoginDTO loginDTO) {
        String msg = "";
        User user = UserRepo.findByEmail(loginDTO.getEmail());
        if (user!= null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> employee = UserRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginMessage("Login Success", true, user.getUserid(), user.getUsername(), user.getEmail());
                }
                else {
                    return new LoginMessage("Login Failed", false,-1, null, null);
                }
            }
            else {
                return new LoginMessage("password Not Match", false,-1, null, null);
            }
        }
        else {
            return new LoginMessage("Email not exits", false,-1,null, null);
        }
    }


}
