package fr.diginamic.banque.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "life_insurances")
public class LifeInsurance extends Compte implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "end_date")
    private LocalDate end_date;

    @Column(name = "rate",nullable = false)
    private double rate;

    public LifeInsurance(){

    }
    public LifeInsurance(LocalDate end_date, double rate) {
        this.end_date = end_date;
        this.rate = rate;
    }

    public LifeInsurance(String number, double balance, Set<Client> clients, LocalDate end_date, double rate) {
        super(number, balance, clients);
        this.end_date = end_date;
        this.rate = rate;
    }

    public LifeInsurance(String number, double balance, Set<Client> clients, Set<Operation> operations, LocalDate end_date, double rate) {
        super(number, balance, clients, operations);
        this.end_date = end_date;
        this.rate = rate;
    }

    public LifeInsurance(String number, double balance, LocalDate end_date, double rate) {
        super(number, balance);
        this.end_date = end_date;
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
     * get field @Column(name = "end_date")
     *
     * @return end_date @Column(name = "end_date")

     */
    public LocalDate getEnd_date() {
        return this.end_date;
    }

    /**
     * set field @Column(name = "end_date")
     *
     * @param end_date @Column(name = "end_date")

     */
    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    /**
     * get field @Column(name = "rate",nullable = false)
     *
     * @return rate @Column(name = "rate",nullable = false)

     */
    public double getRate() {
        return this.rate;
    }

    /**
     * set field @Column(name = "rate",nullable = false)
     *
     * @param rate @Column(name = "rate",nullable = false)

     */
    public void setRate(double rate) {
        this.rate = rate;
    }
}
