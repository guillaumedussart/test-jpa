package fr.diginamic.banque.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestBanque {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
    private static EntityManager em = emf.createEntityManager();


    public static void main(String[] args) {





        emf.close();
        em.close();
    }
}
