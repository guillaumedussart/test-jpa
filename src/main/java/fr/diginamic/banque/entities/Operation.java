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
}
