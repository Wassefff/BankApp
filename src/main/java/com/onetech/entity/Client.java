package com.onetech.entity;




import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Client extends Utilisateur {

    private String demande;
    private Double soldeInitiale=null;

    @Temporal(TemporalType.DATE)
    private Date dateOuverture;
    private String typeCompte;
    private String statut;
    @ManyToOne
  //  @JoinColumn(name = "gestionnaire_id", nullable = false)
    private Gestionnaire gestionnaire;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Reclamation> reclamations;

    @OneToOne
    @JsonBackReference

    private Demande demandes;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Document> documents;
}
