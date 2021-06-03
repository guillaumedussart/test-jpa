package fr.diginamic.jpa.tests;

import fr.diginamic.jpa.bo.Client;
import fr.diginamic.jpa.bo.Emprunt;
import fr.diginamic.jpa.bo.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestBibliotheque {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa-javax");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        Emprunt emprunt = em.find(Emprunt.class, 1L);
        for (Livre livre : emprunt.getLivres()) {
            System.out.println(livre);
        }


        System.out.println("--------------");


        Client client = em.find(Client.class, 1L);
        for (Emprunt emp : client.getEmprunts()) {
            System.out.println(emp.getLivres());
        }
        emf.close();
        em.close();
    }
}
