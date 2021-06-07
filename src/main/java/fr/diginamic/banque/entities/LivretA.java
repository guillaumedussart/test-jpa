package fr.diginamic.banque.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "livrets_a")
public class LivretA extends Compte implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "rate")
    private double rate;

    public LivretA(double rate) {
        this.rate = rate;
    }

    public LivretA(String number, double balance, Set<Client> clients, double rate) {
        super(number, balance, clients);
        this.rate = rate;
    }

    public LivretA(String number, double balance, Set<Client> clients, Set<Operation> operations, double rate) {
        super(number, balance, clients, operations);
        this.rate = rate;
    }

    public LivretA() {

    }

    public LivretA(String number, double balance, double rate) {
        super(number, balance);
        this.rate = rate;
    }

    /**
     * get field @Id
     @GeneratedValue

      *
      * @return id @Id
     @GeneratedValue

     */
    public Long getId() {
        return this.id;
    }

    /**
     * set field @Id
     @GeneratedValue

      *
      * @param id @Id
     @GeneratedValue

     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get field @Column(name = "rate")
     *
     * @return rate @Column(name = "rate")

     */
    public double getRate() {
        return this.rate;
    }

    /**
     * set field @Column(name = "rate")
     *
     * @param rate @Column(name = "rate")

     */
    public void setRate(double rate) {
        this.rate = rate;
    }
}
