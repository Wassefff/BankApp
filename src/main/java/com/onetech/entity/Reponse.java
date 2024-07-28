package com.onetech.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rep;

    private String reponse;

    @OneToOne
   // @JoinColumn(name = "reclamation_id", nullable = false)
    @JsonBackReference
    private Reclamation reclamation;
}
