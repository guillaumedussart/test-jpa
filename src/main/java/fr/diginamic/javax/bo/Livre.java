package fr.diginamic.javax.bo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LIVRE")
public class Livre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String auteur;


    public Livre(Long id) {
        this.id = id;
    }

    public Livre() {
    }

    public Livre(Long id, String titre, String auteur) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
    }

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    /**
     * get field @Id
     *
     * @return id @Id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * set field @Id
     *
     * @param id @Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get field
     *
     * @return titre
     */
    public String getTitre() {
        return this.titre;
    }

    /**
     * set field
     *
     * @param titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * get field
     *
     * @return auteur
     */
    public String getAuteur() {
        return this.auteur;
    }

    /**
     * set field
     *
     * @param auteur
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Livre{");
        sb.append("id=").append(id);
        sb.append(", titre='").append(titre).append('\'');
        sb.append(", auteur='").append(auteur).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
