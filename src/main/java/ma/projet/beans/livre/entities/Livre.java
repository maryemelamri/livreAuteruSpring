package ma.projet.beans.livre.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "livres")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    private  String isbn;
    private String titre;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateEdition;


    @ManyToMany(mappedBy = "livres")
    private Set<Auteur> auteur= new HashSet<>();

    public int getId() {
        return id;
    }

    public Set<Auteur> getAuteur() {
        return auteur;
    }

    public void setAuteur(Set<Auteur> auteur) {
        this.auteur = auteur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }



    public Livre() {
    }
}
