package com.signInSystem.xyz.dao;

import com.signInSystem.xyz.model.UserPassword;
import com.signInSystem.xyz.model.Users;

public interface PasswordMapper {
    public void insertPasswords(UserPassword userPassword);
    public String selectTrueUserPassword(int user_id);

}