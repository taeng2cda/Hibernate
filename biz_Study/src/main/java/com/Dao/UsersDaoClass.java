package com.Dao;

import com.Entity.users;
import com.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class UsersDaoClass implements UsersDao{
    @Override
    public void addUsers(users user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Integer id = (Integer)session.save(user);

            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public users OneSelect(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            users user = session.get(users.class,id);
            if(user != null){
                return user;
            }else {
                System.out.println("검색할 사람이 없음");
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void UpdateUsers(int id, String name) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            users user = session.get(users.class, id);
            if (user != null) {
                user.setName(name);

                session.beginTransaction();
                session.update(user);
                session.getTransaction().commit();
            } else {
                System.out.println("null!!");
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteUsers(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            users user = session.get(users.class, id);
            if (user != null) {
                session.beginTransaction();
                session.delete(user);
                session.getTransaction().commit();
            } else {
                System.out.println("null!!!!!!!!!");
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }

    }
}
