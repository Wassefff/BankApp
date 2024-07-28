package com.onetech.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Reclamation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rec;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String titre;

    @ManyToOne
    @JsonBackReference
   // @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @OneToOne(mappedBy = "reclamation", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Reponse reponse;
}
