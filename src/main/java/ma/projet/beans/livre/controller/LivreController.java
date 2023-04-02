package ma.projet.beans.livre.controller;

import ma.projet.beans.livre.entities.Livre;
import ma.projet.beans.livre.repository.LivreRepository;
import ma.projet.beans.livre.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class LivreController {
@Autowired
LivreService livreService;
@Autowired
LivreRepository livreRepository;

@GetMapping("/livres")
public List<Livre> getAllLivres(){return livreService.getAllLiver();}

@GetMapping("/livres/{isbn}")
public Livre getLivreByIsbn(@PathVariable("isbn") String isbn){return livreService.getLivreByIsbn(isbn);}
    @PostMapping("/livres/save")
public void SaveLivre(@RequestBody Livre livre){ livreService.save(livre);}
    @DeleteMapping("livres/{livreid}/delete")
public void deleteLivre(@PathVariable("livreid") int livreid){ livreService.delete(livreid);}

//between two dates
    @GetMapping("/date")
    public List<Livre> getBooksByEditionDateBetween(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return livreService.findLivresByDateEditionBetween(startDate, endDate);
    }


}
