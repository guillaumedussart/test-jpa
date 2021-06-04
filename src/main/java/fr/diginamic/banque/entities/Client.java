package fr.diginamic.banque.entities;


import fr.diginamic.jpa.bo.Emprunt;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client extends Adresse implements Serializable {

    @Id
    private Long id;

    @Column(name = "lastname", nullable = false, length = 100)
    private String lastname;

    @Column(name = "firstname", nullable = false, length = 100)
    private String firstname;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_banque")
    private Banque banque;


    @ManyToMany
    @JoinTable(name = "client_compte",
            joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id")
    )
    private Set<Compte> comptes;

    public Client() {
        comptes = new HashSet<>();
    }

    public Client(String lastname, String firstname, LocalDate birthday) {

        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
    }

    public Client(int number, String street, int postalCode, String country, Long id, String lastname, String firstname, LocalDate birthday) {
        super(number, street, postalCode, country);
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
    }

    public Client(int number, String street, int postalCode, String country, Long id, String lastname, String firstname, LocalDate birthday, Set<Compte> comptes) {
        super(number, street, postalCode, country);
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
        this.comptes = comptes;
    }

    public Client(String lastname, String firstname, LocalDate birthday, Banque banque, Set<Compte> comptes) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
        this.banque = banque;
        this.comptes = comptes;
    }

    public Client(int number, String street, int postalCode, String country, String lastname, String firstname, LocalDate birthday, Banque banque, Set<Compte> comptes) {
        super(number, street, postalCode, country);
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
        this.banque = banque;
        this.comptes = comptes;
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
     * get field @Column(name = "lastname",nullable = false,length = 100)
     *
     * @return lastname @Column(name = "lastname",nullable = false,length = 100)
     */
    public String getLastname() {
        return this.lastname;
    }

    /**
     * set field @Column(name = "lastname",nullable = false,length = 100)
     *
     * @param lastname @Column(name = "lastname",nullable = false,length = 100)
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * get field @Column(name = "firstname",nullable = false,length = 100)
     *
     * @return firstname @Column(name = "firstname",nullable = false,length = 100)
     */
    public String getFirstname() {
        return this.firstname;
    }

    /**
     * set field @Column(name = "firstname",nullable = false,length = 100)
     *
     * @param firstname @Column(name = "firstname",nullable = false,length = 100)
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * get field @Column(name = "birthday",nullable = false)
     *
     * @return birthday @Column(name = "birthday",nullable = false)
     */
    public LocalDate getBirthday() {
        return this.birthday;
    }

    /**
     * set field @Column(name = "birthday",nullable = false)
     *
     * @param birthday @Column(name = "birthday",nullable = false)
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * get field @ManyToMany
     *
     * @return comptes @ManyToMany
     * @JoinTable(name = "client_compte",
     * joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
     * inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id")
     * )
     * @JoinTable(name = "client_compte",
     * joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
     * inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id")
     * )
     */
    public Set<Compte> getComptes() {
        return this.comptes;
    }

    /**
     * set field @ManyToMany
     *
     * @param comptes @ManyToMany
     * @JoinTable(name = "client_compte",
     * joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
     * inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id")
     * )
     * @JoinTable(name = "client_compte",
     * joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
     * inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id")
     * )
     */
    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }


    /**
     * get field @ManyToOne(cascade = CascadeType.PERSIST)
     @JoinColumn(name = "id_banque")

      *
      * @return banque @ManyToOne(cascade = CascadeType.PERSIST)
     @JoinColumn(name = "id_banque")

     */
    public Banque getBanque() {
        return this.banque;
    }

    /**
     * set field @ManyToOne(cascade = CascadeType.PERSIST)
     @JoinColumn(name = "id_banque")

      *
      * @param banque @ManyToOne(cascade = CascadeType.PERSIST)
     @JoinColumn(name = "id_banque")

     */
    public void setBanque(Banque banque) {
        if (this.banque != null) {
            this.banque.getClients().remove(this);
        }

        this.banque = banque;

        if (this.banque != null) {
            this.banque.getClients().add(this);
        }
    }
}
