package ma.projet.beans.livre.repository;

import ma.projet.beans.livre.entities.Auteur;
import ma.projet.beans.livre.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface LivreRepository extends JpaRepository<Livre,Integer> {
    Livre findByIsbn(String isbn);



    List<Livre> findLivresByDateEditionBetween(Date dateStart, Date dateEnd);

//    String req= "SELECT l FROM livres l WHERE l.date_edition BETWEEN :startDate AND :endDate";
//    @Query(req)
//    List<Livre> findBooksByEditionDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
