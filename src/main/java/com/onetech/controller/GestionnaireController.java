package com.onetech.controller;



import com.onetech.entity.Demande;
import com.onetech.repository.DemandeRepository;
import com.onetech.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/gestionnaires")
public class GestionnaireController {

    @Autowired
    private DemandeService demandeService;

    // Endpoint pour changer le statut d'une demande
    @PutMapping("/demandes/{id}/statut")
    public Demande changerStatutDemande(@PathVariable Long id) {
        Optional<Demande> optionalDemande = demandeService.getDemandeById(id);
        if (optionalDemande.isPresent()) {
            Demande demande = optionalDemande.get();
            demande.setStatus(true);
            return demandeService.updateDemande(id, demande);
        } else {
            throw new RuntimeException("Demande non trouvée avec l'id: " + id);
        }
    }
}
