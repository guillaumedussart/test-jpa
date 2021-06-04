package fr.diginamic.banque.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adresses")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Adresse implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "number", nullable = false, length = 10)
    private int number;

    @Column(name = "street", nullable = false, length = 100)
    private String street;

    @Column(name = "postal_code", nullable = false, length = 10)
    private int postalCode;

    @Column(name = "counrty", nullable = false, length = 50)
    private String country;

    public Adresse() {
    }


    public Adresse(int number, String street, int postalCode, String country) {
        this.number = number;
        this.street = street;
        this.postalCode = postalCode;
        this.country = country;
    }

    public int getDept() {
        return this.getPostalCode() / 1000;
    }

    /**
     * get field @Id
     *
     * @return id @Id
     * @Column(name = "id")
     * @GeneratedValue
     * @Column(name = "id")
     * @GeneratedValue
     */
    public Long getId() {
        return this.id;
    }

    /**
     * set field @Id
     *
     * @param id @Id
     * @Column(name = "id")
     * @GeneratedValue
     * @Column(name = "id")
     * @GeneratedValue
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get field @Column(name = "number", nullable = false, length = 10)
     *
     * @return number @Column(name = "number", nullable = false, length = 10)
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * set field @Column(name = "number", nullable = false, length = 10)
     *
     * @param number @Column(name = "number", nullable = false, length = 10)
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * get field @Column(name = "street", nullable = false, length = 100)
     *
     * @return street @Column(name = "street", nullable = false, length = 100)
     */
    public String getStreet() {
        return this.street;
    }

    /**
     * set field @Column(name = "street", nullable = false, length = 100)
     *
     * @param street @Column(name = "street", nullable = false, length = 100)
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * get field @Column(name = "postal_code", nullable = false, length = 10)
     *
     * @return postalCode @Column(name = "postal_code", nullable = false, length = 10)
     */
    public int getPostalCode() {
        return this.postalCode;
    }

    /**
     * set field @Column(name = "postal_code", nullable = false, length = 10)
     *
     * @param postalCode @Column(name = "postal_code", nullable = false, length = 10)
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * get field @Column(name = "counrty", nullable = false, length = 50)
     *
     * @return country @Column(name = "counrty", nullable = false, length = 50)
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * set field @Column(name = "counrty", nullable = false, length = 50)
     *
     * @param country @Column(name = "counrty", nullable = false, length = 50)
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
