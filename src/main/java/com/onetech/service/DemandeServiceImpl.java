package com.onetech.service;



import com.onetech.entity.Demande;
import com.onetech.repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeServiceImpl implements DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    @Override
    public Demande createDemande(Demande demande) {
        return demandeRepository.save(demande);
    }

    @Override
    public Optional<Demande> getDemandeById(Long id) {
        return demandeRepository.findById(id);
    }

    @Override
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    @Override
    public Demande updateDemande(Long id, Demande demande) {
        if (!demandeRepository.existsById(id)) {
            throw new RuntimeException("Demande not found");
        }
        demande.setId_dem(id);  // S'assurer de définir l'ID pour la mise à jour
        return demandeRepository.save(demande);
    }

    @Override
    public void deleteDemande(Long id) {
        if (!demandeRepository.existsById(id)) {
            throw new RuntimeException("Demande not found");
        }
        demandeRepository.deleteById(id);
    }
}
