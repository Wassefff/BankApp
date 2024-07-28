package com.onetech.entity;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_doc;

    private String type;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}
