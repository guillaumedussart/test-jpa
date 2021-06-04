package fr.diginamic.jpa.bo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    @Id
    private Long id;

    @Column(name = "NOM", nullable = false)
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @OneToMany(mappedBy = "client")
    private Set<Emprunt> emprunts;

    public Client() {
        emprunts = new HashSet<Emprunt>();
    }

    public Client(Long id) {
        this.id = id;
    }

    public Client(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Client(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client(Long id, String nom, String prenom, Set<Emprunt> emprunts) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.emprunts = emprunts;
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
     * get field @Column(name = "NOM", nullable = false)
     *
     * @return nom @Column(name = "NOM", nullable = false)

     */
    public String getNom() {
        return this.nom;
    }

    /**
     * set field @Column(name = "NOM", nullable = false)
     *
     * @param nom @Column(name = "NOM", nullable = false)

     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * get field @Column(name = "PRENOM")
     *
     * @return prenom @Column(name = "PRENOM")

     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * set field @Column(name = "PRENOM")
     *
     * @param prenom @Column(name = "PRENOM")

     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * get field @OneToMany(mappedBy = "client")
     *
     * @return emprunts @OneToMany(mappedBy = "client")

     */
    public Set<Emprunt> getEmprunts() {
        return this.emprunts;
    }

    /**
     * set field @OneToMany(mappedBy = "client")
     *
     * @param emprunts @OneToMany(mappedBy = "client")

     */
    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    /**
     * add emprunt
     *
     * @param emprunt emprunt
     */
    public void addEmprunt(Emprunt emprunt) {
        if (emprunt != null) {
            emprunt.setClient(this);
        }
    }
}
