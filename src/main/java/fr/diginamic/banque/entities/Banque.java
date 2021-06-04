package fr.diginamic.banque.entities;

import fr.diginamic.jpa.bo.Emprunt;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "banques")
public class Banque extends Adresse implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name",nullable = false,length = 100)
    private String name;

    public Banque(){

    }

    public Banque(String name) {
        this.name = name;
    }

    public Banque(int number, String street, int postalCode, String country, String name) {
        super(number, street, postalCode, country);
        this.name = name;
    }

    /**
     * get field @Id
     @Column(name = "id")
     @GeneratedValue(strategy = GenerationType.AUTO)

      *
      * @return id @Id
     @Column(name = "id")
     @GeneratedValue(strategy = GenerationType.AUTO)

     */
    public Long getId() {
        return this.id;
    }

    /**
     * set field @Id
     @Column(name = "id")
     @GeneratedValue(strategy = GenerationType.AUTO)

      *
      * @param id @Id
     @Column(name = "id")
     @GeneratedValue(strategy = GenerationType.AUTO)

     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get field @Column(name="name",nullable = false,length = 100)
     *
     * @return name @Column(name="name",nullable = false,length = 100)

     */
    public String getName() {
        return this.name;
    }

    /**
     * set field @Column(name="name",nullable = false,length = 100)
     *
     * @param name @Column(name="name",nullable = false,length = 100)

     */
    public void setName(String name) {
        this.name = name;
    }

}
