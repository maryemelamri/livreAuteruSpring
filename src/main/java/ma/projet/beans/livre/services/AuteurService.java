package ma.projet.beans.livre.services;


import ma.projet.beans.livre.entities.Auteur;
import ma.projet.beans.livre.entities.Livre;
import ma.projet.beans.livre.repository.AuteurRepository;
import ma.projet.beans.livre.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuteurService {
    @Autowired
    AuteurRepository auteurRepository;
    @Autowired
    LivreRepository livreRepository;

    public List<Auteur> getAllLiver() {
        return  auteurRepository.findAll();
    }

    public Auteur getauteurById(int id){
        return auteurRepository.findById(id).get();
    }
    public Auteur getauteurByCin(String cin ){

        return auteurRepository.findByCin(cin);
    }
    //Curd
    public void save(Auteur auteur){
        auteurRepository.save(auteur);
    }
    public void delete(int id){
        auteurRepository.deleteById(id);
    }
    public void update(Auteur auteur, int auteurId){
        auteurRepository.save(auteur);
    }

    public Optional<Auteur> getById(int id){
        return auteurRepository.findById(id);
    }

    public void assignLivreAuteur(int idAuteur,int idLivre){
      Optional<Auteur> auteur = this.getById(idAuteur);
      Optional<Livre> livre = livreRepository.findById(idLivre);
    if(auteur.isPresent() && livre.isPresent()){
        Auteur auteurModif = auteur.get();
        auteurModif.getLivres().add(livre.get());
        auteurRepository.save(auteurModif);

    }else System.out.println("not found auteur or livre");

    }

}
