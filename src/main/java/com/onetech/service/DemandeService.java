package com.onetech.service;



import com.onetech.entity.Demande;

import java.util.List;
import java.util.Optional;

public interface DemandeService {

    Demande createDemande(Demande demande);

    Optional<Demande> getDemandeById(Long id);

    List<Demande> getAllDemandes();

    Demande updateDemande(Long id, Demande demande);

    void deleteDemande(Long id);
}
