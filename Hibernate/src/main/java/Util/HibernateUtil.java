package Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    static {
        if (entityManager == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("BlogServlet");
                entityManager = entityManagerFactory.createEntityManager();
            } catch (IllegalStateException e) {
                e.printStackTrace();
                HibernateUtil.closeEntityManager();
            }
        }
    }
    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static void closeEntityManager() {
        try {
            if (entityManager instanceof EntityManager) {
                entityManager.close();
            }
            if (entityManagerFactory instanceof EntityManagerFactory) {
                entityManagerFactory.close();
            }
        } catch (IllegalStateException e) {
            System.out.println("connection close error");
        }
    }

}
