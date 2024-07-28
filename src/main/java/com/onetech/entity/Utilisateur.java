package com.onetech.entity;




import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String adresse;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private String email;
    private String motDePasse;
    private String role;
}
