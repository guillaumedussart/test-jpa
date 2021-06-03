package fr.diginamic.jpa.bll;

import fr.diginamic.jpa.bo.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class LivreService {

    private static LivreService single;

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa-javax");
    private static EntityManager em = emf.createEntityManager();

    public LivreService() {
    }

    public static LivreService getSingle() {

        if (null == single) {
            single = new LivreService();
        }
        return single;
    }

    /**
     * list livre
     *
     * @return {@link List}
     * @see List
     * @see Livre
     */
    public List<Livre> listLivre() {
        TypedQuery<Livre> query = em.createQuery("SELECT e FROM Livre e ", Livre.class);
        List<Livre> livres = query.getResultList();
        return livres;
    }
}
