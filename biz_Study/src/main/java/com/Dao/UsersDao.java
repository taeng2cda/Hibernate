package com.Dao;

import com.Entity.users;

public interface UsersDao {

    public abstract void addUsers(users user);
    public abstract users OneSelect (int id);
    public abstract void UpdateUsers(int id , String name);
    public abstract void DeleteUsers(Integer id);

}
