package ma.projet.beans.livre.services;

import ma.projet.beans.livre.entities.Livre;
import ma.projet.beans.livre.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class LivreService {
    @Autowired
    private LivreRepository livreRepository;
    //getMethods
    public List<Livre> getAllLiver() {
        return  livreRepository.findAll();
    }

    public Livre getLivreById(int id){
        return livreRepository.findById(id).get();
    }
    public Livre getLivreByIsbn(String isbn ){
        System.out.println("true");
        return livreRepository.findByIsbn(isbn);
    }
    //Curd
    public void save(Livre livre){
        livreRepository.save(livre);
    }
    public void delete(int id){
        livreRepository.deleteById(id);
    }
    public void update(Livre livre, int livreId){
        livreRepository.save(livre);
    }

    public List<Livre> findLivresByDateEditionBetween(Date startDate, Date endDate) {
        return livreRepository.findLivresByDateEditionBetween(startDate, endDate);
    }
}
