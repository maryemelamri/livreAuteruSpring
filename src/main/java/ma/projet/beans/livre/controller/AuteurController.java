package ma.projet.beans.livre.controller;

import ma.projet.beans .livre.entities.Auteur;
import ma.projet.beans.livre.entities.Livre;
import ma.projet.beans.livre.repository.AuteurRepository;
import ma.projet.beans.livre.services.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class AuteurController {
    @Autowired
    AuteurService auteurService;
    @Autowired
    AuteurRepository auteurRepository;
    @GetMapping("/aji/{id}")
    public Optional<Auteur> getAuteur(@PathVariable("id") int id)
    { return auteurRepository.findById(id);}
    @GetMapping("/auteurs")
    public List<Auteur> getAllauteurs(){return auteurService.getAllLiver();}

    @GetMapping("/auteurs/{cin}")
    public Auteur getauteurByCin(@PathVariable("cin") String cin){return auteurService.getauteurByCin(cin);}
    @PostMapping("/auteurs/save")
    public void Saveauteur(@RequestBody Auteur auteur){ auteurService.save(auteur);}
    @DeleteMapping("auteurs/{auteurid}/delete")
    public void deleteauteur(@PathVariable("auteurid") int auteurid){ auteurService.delete(auteurid);}

    //livre d'un auteur
    @GetMapping("/auteurs/livres/{cin}")
    public Set<Livre> findByLivre(@PathVariable("cin") String cin) {
        Auteur auteur= auteurService.getauteurByCin(cin);
        return  auteur.getLivres();}


    @PostMapping("/{authorId}/books/{bookId}")
    public void assignBookToAuthor(
            @PathVariable("authorId") int auteurId, @PathVariable("bookId") int livreId) {
        auteurService.assignLivreAuteur(auteurId, livreId);

    }
}
