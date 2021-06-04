package fr.diginamic.banque.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "comptes")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte implements Serializable {

    @Id
    private Long id;

    @Column(name = "number", nullable = false, length = 50)
    private String number;

    @Column(name = "balance", nullable = false)
    private double balance;

    @ManyToMany(mappedBy = "comptes")
    private Set<Client> clients;

    @OneToMany
    private Set<Operation> operations;


    public Compte() {
    }

    public Compte(String number, double balance, Set<Client> clients) {
        this.number = number;
        this.balance = balance;
        this.clients = clients;
    }

    public Compte(String number, double balance, Set<Client> clients, Set<Operation> operations) {
        this.number = number;
        this.balance = balance;
        this.clients = clients;
        this.operations = operations;
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
     * get field @Column(name = "number", nullable = false, length = 50)
     *
     * @return number @Column(name = "number", nullable = false, length = 50)

     */
    public String getNumber() {
        return this.number;
    }

    /**
     * set field @Column(name = "number", nullable = false, length = 50)
     *
     * @param number @Column(name = "number", nullable = false, length = 50)

     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * get field @Column(name = "balance", nullable = false)
     *
     * @return balance @Column(name = "balance", nullable = false)

     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * set field @Column(name = "balance", nullable = false)
     *
     * @param balance @Column(name = "balance", nullable = false)

     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * get field @ManyToMany(mappedBy = "comptes")
     *
     * @return clients @ManyToMany(mappedBy = "comptes")

     */
    public Set<Client> getClients() {
        return this.clients;
    }

    /**
     * set field @ManyToMany(mappedBy = "comptes")
     *
     * @param clients @ManyToMany(mappedBy = "comptes")

     */
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    /**
     * get field @OneToMany
     *
     * @return operations @OneToMany

     */
    public Set<Operation> getOperations() {
        return this.operations;
    }

    /**
     * set field @OneToMany
     *
     * @param operations @OneToMany

     */
    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }
}
