package com.Service;

import com.Entity.users;

public interface UsersService {

    public abstract void CreateUsers(users user);
    public abstract users SelectOneUsers(int id);
    public abstract void UpdateUsers(int id , String name);
    public abstract void DeleteUsers(int id);

}
