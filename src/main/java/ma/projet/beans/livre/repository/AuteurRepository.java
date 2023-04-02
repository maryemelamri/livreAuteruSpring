package ma.projet.beans.livre.repository;

import ma.projet.beans.livre.entities.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuteurRepository  extends JpaRepository<Auteur,Integer> {
    Auteur findByCin(String cin);
    Optional<Auteur> findById(int id);
}
