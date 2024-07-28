package com.onetech.controller;


import com.onetech.entity.Reponse;
import com.onetech.service.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reponses")
public class ReponseController {

    @Autowired
    private ReponseService reponseService;

    @PostMapping("/addReponse/{idRec}")
    public Reponse createReponse(@RequestBody Reponse reponse,@PathVariable Long idRec) {
        return reponseService.createReponse(reponse,idRec);
    }

    @GetMapping("/{id}")
    public Optional<Reponse> getReponseById(@PathVariable Long id) {
        return reponseService.getReponseById(id);
    }

    @GetMapping
    public List<Reponse> getAllReponses() {
        return reponseService.getAllReponses();
    }

    @PutMapping("/{id}")
    public Reponse updateReponse(@PathVariable Long id, @RequestBody Reponse reponse) {
        return reponseService.updateReponse(id, reponse);
    }

    @DeleteMapping("/{id}")
    public void deleteReponse(@PathVariable Long id) {
        reponseService.deleteReponse(id);
    }
}

