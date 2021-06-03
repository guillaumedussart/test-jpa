package fr.diginamic.javax;

import fr.diginamic.javax.bo.Fournisseur;
import fr.diginamic.javax.bo.Livre;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class App {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa-javax");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        findOneForurnisseur(1L);
        setNewFournisseur("La Maison de la Peinture2");
        /*




         */
        /*em.getTransaction().begin();
        Livre livreN = new Livre("Test liver Insert", "Arthur Test");
        em.persist(livreN);

        Livre livreU = em.find(Livre.class,5L);
        livreU.setTitre("Du plaisir dans la cuisine");



        em.getTransaction().commit();*/
        Livre livre1 = em.find(Livre.class, 1L);
        System.out.println(livre1.toString());
        System.out.println("---------------------------------");

        TypedQuery<Livre> query = em.createQuery("SELECT e FROM Livre e WHERE e.titre=:titre", Livre.class);
        query.setParameter("titre", "Germinal");
        List<Livre> livres = query.getResultList();

        for (Livre l : livres) {
            System.out.println(l);
        }
        em.close();
        emf.close();

    }

    /**
     * find one forurnisseur
     *
     * @param aLong aLong
     */
    private static void findOneForurnisseur(Long aLong) {
        Fournisseur oneFournisseur = em.find(Fournisseur.class, 3l);
        System.out.println(oneFournisseur);
    }

    /**
     * set new fournisseur
     *
     * @param fournisseur fournisseur
     */
    private static void setNewFournisseur(String fournisseur) {
        try {

            em.getTransaction().begin();

            Fournisseur fournisseur1 = new Fournisseur(fournisseur);
            em.persist(fournisseur1);

            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * list livre
     *
     * @return {@link List}
     * @see List
     * @see Livre
     */
    private static List<Livre> listLivre() {
        TypedQuery<Livre> query = em.createQuery("SELECT e FROM Livre e ", Livre.class);
        List<Livre> livres = query.getResultList();
        return livres;
    }

    /**
     * set new livre
     *
     * @param title  title
     * @param author author
     */
    private static void setNewLivre(String title, String author) {
        em.getTransaction().begin();
        Livre livreN = new Livre(title, author);
        em.persist(livreN);
        em.getTransaction().commit();
    }

    /**
     * get livre by title
     *
     * @param title title
     * @return {@link Livre}
     * @see Livre
     */
    private static Livre getLivreByTitle(String title){
        TypedQuery<Livre> typed = em.createQuery("SELECT e FROM Livre e WHERE e.titre=:titre", Livre.class).setParameter("titre", title);
        try {
            return typed.getSingleResult();
        } catch (final NoResultException nre) {
            return null;
        }
    }

    /**
     * get livre by author
     *
     * @param author author
     * @return {@link Livre}
     * @see Livre
     */
    private static Livre getLivreByAuthor(String author){
        TypedQuery<Livre> typed = em.createQuery("SELECT e FROM Livre e WHERE e.auteur=:auteur", Livre.class).setParameter("auteur", author);
        try {
            return typed.getSingleResult();
        } catch (final NoResultException nre) {
            return null;
        }
    }
}
