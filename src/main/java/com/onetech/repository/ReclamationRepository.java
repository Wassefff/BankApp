package com.onetech.repository;



import com.onetech.entity.Reclamation;
import com.onetech.entity.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
    @Query("SELECT r.reponse FROM Reclamation r WHERE r.id_rec = :reclamationId")
    Reponse findReponseByReclamationId(Long reclamationId);
}
