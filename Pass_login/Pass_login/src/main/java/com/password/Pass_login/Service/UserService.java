package com.password.Pass_login.Service;

import com.password.Pass_login.DTO.LoginDTO;
import com.password.Pass_login.DTO.UserDTO;
import com.password.Pass_login.payload.response.LoginMessage;

public interface UserService {
    LoginMessage login(LoginDTO loginDTO);
    int addUser(UserDTO userDTO);
}
