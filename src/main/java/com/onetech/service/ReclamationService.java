package com.onetech.service;



import com.onetech.entity.Reclamation;

import java.util.List;
import java.util.Optional;

public interface ReclamationService {

    Reclamation createReclamation(Reclamation reclamation);

    Optional<Reclamation> getReclamationById(Long id);

    List<Reclamation> getAllReclamations();

    Reclamation updateReclamation(Long id, Reclamation reclamation);

    void deleteReclamation(Long id);
}

