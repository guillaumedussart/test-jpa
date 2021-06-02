package fr.diginamic.javax;

import fr.diginamic.javax.bo.Fournisseur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa-javax");
        EntityManager em = emf.createEntityManager();


        Fournisseur oneFournisseur = em.find(Fournisseur.class, 3l);
        System.out.println(oneFournisseur);

        em.getTransaction().begin();

        Fournisseur fournisseur1 = new Fournisseur("Test Four");
        em.persist(fournisseur1);

        em.getTransaction().commit();


        em.close();
        emf.close();

    }
}
