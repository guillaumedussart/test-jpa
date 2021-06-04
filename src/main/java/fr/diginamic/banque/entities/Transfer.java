package fr.diginamic.banque.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transfers")
public class Transfer extends Operation implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "beneficiary", nullable = false, length = 100)
    private String beneficiary;

    public Transfer() {

    }

    public Transfer(String beneficiary) {
        this.beneficiary = beneficiary;
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
     * get field @Column(name = "beneficiary", nullable = false, length = 100)
     *
     * @return beneficiary @Column(name = "beneficiary", nullable = false, length = 100)

     */
    public String getBeneficiary() {
        return this.beneficiary;
    }

    /**
     * set field @Column(name = "beneficiary", nullable = false, length = 100)
     *
     * @param beneficiary @Column(name = "beneficiary", nullable = false, length = 100)

     */
    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }
}
