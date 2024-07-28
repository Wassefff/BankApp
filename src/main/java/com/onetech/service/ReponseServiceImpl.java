package com.onetech.service;



import com.onetech.entity.Reponse;
import com.onetech.entity.Reclamation;
import com.onetech.repository.ReponseRepository;
import com.onetech.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReponseServiceImpl implements ReponseService {

    @Autowired
    private ReponseRepository reponseRepository;

    @Autowired
    private ReclamationRepository reclamationRepository;

    @Override
    public Reponse createReponse(Reponse reponse, Long reclamationId) {
        Optional<Reclamation> reclamationOpt = reclamationRepository.findById(reclamationId);
        if (!reclamationOpt.isPresent()) {
            throw new RuntimeException("Reclamation not found");
        }
        Reclamation reclamation = reclamationOpt.get();
        reponse.setReclamation(reclamation);
        return reponseRepository.save(reponse);
    }

    @Override
    public Optional<Reponse> getReponseById(Long id) {
        return reponseRepository.findById(id);
    }

    @Override
    public List<Reponse> getAllReponses() {
        return reponseRepository.findAll();
    }

    @Override
    public Reponse updateReponse(Long id, Reponse reponse) {
        if (!reponseRepository.existsById(id)) {
            throw new RuntimeException("Reponse not found");
        }
        reponse.setId_rep(id);  // Make sure to set the ID for the update
        return reponseRepository.save(reponse);
    }

    @Override
    public void deleteReponse(Long id) {
        if (!reponseRepository.existsById(id)) {
            throw new RuntimeException("Reponse not found");
        }
        reponseRepository.deleteById(id);
    }

    @Override
    public Reponse getReponseByReclamationId(Long reclamationId) {

        return reclamationRepository.findReponseByReclamationId(reclamationId);
    }
}
