package com.onetech.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_dem;

    private boolean status=false;

    @Temporal(TemporalType.DATE)
    private Date dateSoumission=new Date();

    @OneToOne(mappedBy = "demandes", cascade = CascadeType.ALL)
    @JsonManagedReference
    //   @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
  //  @JoinColumn(name = "gestionnaire_id", nullable = false)
    private Gestionnaire gestionnaire;
}
