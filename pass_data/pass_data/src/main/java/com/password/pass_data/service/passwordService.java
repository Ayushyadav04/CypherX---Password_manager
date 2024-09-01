package com.password.pass_data.service;

import com.password.pass_data.model.password_list;
import java.util.List;

//@Repository
public interface passwordService {
    List<password_list> getPasswordListById(int id) throws Exception;

    void deletePasswordListById(int id) throws Exception;

    void deletePasswordListByNameWebsitePassword(password_list passwordList) throws Exception;
}
