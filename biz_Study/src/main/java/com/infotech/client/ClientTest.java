package com.infotech.client;


import com.Entity.users;
import com.Service.UsersService;
import com.Service.UsersServiceClass;
import com.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Date;

public class ClientTest {
    public static void main(String[] args) {
        UsersService service = new UsersServiceClass();

        //CreateUser(service);
        //SelectOneUsers(service);
        //UpdateUsers(service);
        DeleteUsers(service);

    }

    private static void CreateUser(UsersService service) {
        service.CreateUsers(getUsers());
    }


    private static users getUsers(){
        users user = new users();
        user.setEmail("test3");
        user.setPassword("1234");
        user.setName("테스트");
        user.setCreated_at(new Date());
        user.setUpdated_at(new Date());
        return user;
    }

    // select one
    private static  void SelectOneUsers(UsersService service){
        users user = service.SelectOneUsers(1);
        System.out.println(user);

    }

    //update
    private static void UpdateUsers(UsersService service){
        service.UpdateUsers(1,"수정값");

    }

    //delete
    private static void DeleteUsers(UsersService service){
        service.DeleteUsers(3);

    }

}
