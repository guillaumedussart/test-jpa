package fr.diginamic.banque.tests;

import fr.diginamic.banque.entities.Client;
import fr.diginamic.banque.entities.Compte;
import fr.diginamic.banque.entities.LifeInsurance;
import fr.diginamic.banque.entities.LivretA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class TestBanque {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
    private static EntityManager em = emf.createEntityManager();


    public static void main(String[] args) {
        em.getTransaction().begin();

        /*================================*/

        Compte compte1 = new Compte("FR001-236-598-265", 6000.5);
        em.persist(compte1);
        Set<Compte> compte = new HashSet<>();
        compte.add(compte1);
        Client client1 = new Client(12, "Bazinghien", 59120, "Loos", "Maurice", "Philip", LocalDate.of(1982, 12, 01), compte);
        Client client2 = new Client(112, "Foch", 59120, "Loos", "Davidson", "Harley", LocalDate.of(1982, 11, 25), compte);
        em.persist(client1);
        em.persist(client2);


        /*=========================*/

        LivretA livreta = new LivretA("FR-259-652", 200.3, 20.3);
        LifeInsurance lifeass = new LifeInsurance("FR-258-695-36", 500.9, LocalDate.of(2021, 11, 05), 15.3);
        em.persist(livreta);
        em.persist(lifeass);
        Set<Compte> newCompte = new HashSet<>();
        newCompte.add(livreta);
        newCompte.add(lifeass);
        Client client3 = new Client(12, "Bazinghien", 59120, "Loos", "Maurice2", "Philip2", LocalDate.of(1982, 12, 01), newCompte);
        em.persist(client3);

        em.getTransaction().commit();
Client client = em.find(Client.class,3L);
        System.out.println(client.getCountry());
        emf.close();
        em.close();
    }

    private void opreationCompte(Compte c1,Compte c2,double amount){
        //amount - c1.getBalance();

    }
}
