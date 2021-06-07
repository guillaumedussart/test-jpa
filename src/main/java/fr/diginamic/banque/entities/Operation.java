package fr.diginamic.banque.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "operations")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation implements Serializable {

    @Id
    private Long id;

    @Column(name = "date",nullable = false)
    private LocalDateTime date;

    @Column(name = "amount",nullable = false)
    private double amount;

    @Column(name = "motif",nullable = false,length = 200)
    private String motif;

    @ManyToOne()
    @JoinColumn(name = "id_compte")
    private Compte compte;



    public Operation() {
    }

    public Operation(LocalDateTime date, double amount, String motif) {
        this.date = date;
        this.amount = amount;
        this.motif = motif;
    }

    public Operation(LocalDateTime date, double amount, String motif, Compte compte) {
        this.date = date;
        this.amount = amount;
        this.motif = motif;
        this.compte = compte;
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
     * get field @Column(name = "date",nullable = false)
     *
     * @return date @Column(name = "date",nullable = false)

     */
    public LocalDateTime getDate() {
        return this.date;
    }

    /**
     * set field @Column(name = "date",nullable = false)
     *
     * @param date @Column(name = "date",nullable = false)

     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * get field @Column(name = "amount",nullable = false)
     *
     * @return amount @Column(name = "amount",nullable = false)

     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * set field @Column(name = "amount",nullable = false)
     *
     * @param amount @Column(name = "amount",nullable = false)

     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * get field @Column(name = "motif",nullable = false,length = 200)
     *
     * @return motif @Column(name = "motif",nullable = false,length = 200)

     */
    public String getMotif() {
        return this.motif;
    }

    /**
     * set field @Column(name = "motif",nullable = false,length = 200)
     *
     * @param motif @Column(name = "motif",nullable = false,length = 200)

     */
    public void setMotif(String motif) {
        this.motif = motif;
    }

    /**
     * get field @ManyToOne()
     @JoinColumn(name = "id_compte")

      *
      * @return compte @ManyToOne()
     @JoinColumn(name = "id_compte")

     */
    public Compte getCompte() {
        return this.compte;
    }

    /**
     * set field @ManyToOne()
     @JoinColumn(name = "id_compte")

      *
      * @param compte @ManyToOne()
     @JoinColumn(name = "id_compte")

     */
    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
