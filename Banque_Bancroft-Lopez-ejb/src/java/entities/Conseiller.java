/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
/**
 *
 * @author Luke
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Conseiller.findAll",
        query = "SELECT c FROM Conseiller c"),
    @NamedQuery(name = "Conseiller.findById",
        query = "SELECT c FROM Conseiller c WHERE c.id = :id"),
    @NamedQuery(name = "Conseiller.getNbAConseillers", 
        query = "SELECT COUNT(c) FROM Conseiller c")
})
public class Conseiller extends Personne implements Serializable {

    private Long numConseiller;
    
    public Conseiller() {
    }
    
    public Conseiller(String username, String password, Long numConseiller) {
        super(username, password);
        this.numConseiller = numConseiller;
    }

    @Override
    public Long getId() {
        return id;
    }
    
    public Long getNumConseiller() {
        return numConseiller;
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setNumConseiller(Long numConseiller) {
        this.numConseiller = numConseiller;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conseiller)) {
            return false;
        }
        Conseiller other = (Conseiller) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Conseiller[ id=" + id + " ]";
    }
    
}
