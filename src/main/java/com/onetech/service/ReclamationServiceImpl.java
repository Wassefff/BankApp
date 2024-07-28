package com.onetech.service;



import com.onetech.entity.Reclamation;
import com.onetech.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamationServiceImpl implements ReclamationService {

    @Autowired
    private ReclamationRepository reclamationRepository;

    @Override
    public Reclamation createReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Optional<Reclamation> getReclamationById(Long id) {
        return reclamationRepository.findById(id).stream().findFirst();
    }

    @Override
    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    @Override
    public Reclamation updateReclamation(Long id, Reclamation reclamation) {
        if (!reclamationRepository.existsById(id)) {
            throw new RuntimeException("Reclamation not found");
        }
        reclamation.setId_rec(id);  // Make sure to set the ID for the update
        return reclamationRepository.save(reclamation);
    }

    @Override
    public void deleteReclamation(Long id) {
        if (!reclamationRepository.existsById(id)) {
            throw new RuntimeException("Reclamation not found");
        }
        reclamationRepository.deleteById(id);
    }
}
