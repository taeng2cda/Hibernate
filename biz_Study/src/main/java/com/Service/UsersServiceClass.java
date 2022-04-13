package com.Service;

import com.Dao.UsersDaoClass;
import com.Entity.users;

public class UsersServiceClass implements UsersService{
    @Override
    public void CreateUsers(users user) {
        new UsersDaoClass().addUsers(user);
    }

    @Override
    public users SelectOneUsers(int id) {
        return new UsersDaoClass().OneSelect(id);
    }

    @Override
    public void UpdateUsers(int id, String name) {
        new UsersDaoClass().UpdateUsers(id, name);
    }

    @Override
    public void DeleteUsers(int id) {
        new UsersDaoClass().DeleteUsers(id);
    }
}
