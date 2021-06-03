package fr.diginamic.jpa;

import fr.diginamic.jpa.bll.LivreService;
import fr.diginamic.jpa.bo.Fournisseur;
import fr.diginamic.jpa.bo.Livre;

import javax.persistence.*;
import java.util.List;

public class App {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa-javax");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {


        LivreService service = LivreService.getSingle();


        List<Livre> livreList = service.listLivre();
        for (Livre l : livreList) {
            System.out.println(l);
        }
        findOneForurnisseur(1L);
       getLivreByTitle("Test liver Insert");

        //setNewFournisseur("La Maison de la Peinture2");
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
    private static List<Livre> getLivreByTitle(String title) {
        TypedQuery<Livre> typed = em.createQuery("SELECT l FROM Livre l WHERE l.titre=:titre", Livre.class).setParameter("titre", title);
        try {
            List<Livre> livres = typed.getResultList();


            return livres;
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
    private static Livre getLivreByAuthor(String author) {
        TypedQuery<Livre> typed = em.createQuery("SELECT e FROM Livre e WHERE e.auteur=:auteur", Livre.class).setParameter("auteur", author);
        try {
            return typed.getSingleResult();
        } catch (final NoResultException nre) {
            return null;
        }
    }
}
