package ma.projet.beans.livre.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "auteur")
public class Auteur extends Personne {


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "auteur_livre",
            joinColumns = @JoinColumn(name = "auteur_id", referencedColumnName= "id"),
            inverseJoinColumns = @JoinColumn(name = "livre_id",referencedColumnName= "id")
    )
    private Set<Livre> livres = new HashSet<>();

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
