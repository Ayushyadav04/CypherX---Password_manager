package com.add_pass.add_pass.service;

import com.add_pass.add_pass.Model.password_list;

public interface passwordService {
    void postPasswordList(password_list passwordList)throws Exception;
}
