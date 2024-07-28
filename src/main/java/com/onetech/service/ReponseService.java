package com.onetech.service;




import com.onetech.entity.Reponse;

import java.util.List;
import java.util.Optional;

public interface ReponseService {

    Reponse createReponse(Reponse reponse, Long reclamationId);

    Optional<Reponse> getReponseById(Long id);

    List<Reponse> getAllReponses();

    Reponse updateReponse(Long id, Reponse reponse);

    void deleteReponse(Long id);

    Reponse getReponseByReclamationId(Long reclamationId);
}
