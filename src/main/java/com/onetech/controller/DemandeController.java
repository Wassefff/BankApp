package com.onetech.controller;


import com.onetech.entity.Demande;
import com.onetech.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demandes")
public class DemandeController {

    @Autowired
    private DemandeService demandeService;

    @GetMapping("/{id}")
    public Optional<Demande> getDemandeById(@PathVariable Long id) {
        return demandeService.getDemandeById(id);
    }

    @GetMapping
    public List<Demande> getAllDemandes() {
        return demandeService.getAllDemandes();
    }

    @PutMapping("/{id}")
    public Demande updateDemande(@PathVariable Long id, @RequestBody Demande demande) {
        return demandeService.updateDemande(id, demande);
    }

    @DeleteMapping("/{id}")
    public void deleteDemande(@PathVariable Long id) {
        demandeService.deleteDemande(id);
    }
}
