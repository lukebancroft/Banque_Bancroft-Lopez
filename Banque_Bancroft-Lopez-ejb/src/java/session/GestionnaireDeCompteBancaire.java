/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.CompteBancaire;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Fabien
 */
@Stateless
@LocalBean
public class GestionnaireDeCompteBancaire {

    @PersistenceContext(unitName = "Banque_Bancroft-Lopez-ejbPU")
    private EntityManager em;

    public void creerCompte(CompteBancaire c) {
        persist(c);
    }

    public CompteBancaire getCompteBancaire(int idCompteBancaire) {  
        return em.find(CompteBancaire.class, idCompteBancaire);  
    }  
    
    public List<CompteBancaire> getAllCompteBancaires() {
        Query query = em.createNamedQuery("CompteBancaire.findAll");  
        return query.getResultList();
    }

    public CompteBancaire update(CompteBancaire compteBancaire) {
        return em.merge(compteBancaire);
    }

    public void persist(Object object) {
        em.persist(object);
    }

    /*public void creerComptesTest() {  
        creerCompte(new CompteBancaire("John Lennon", 150000));  
        creerCompte(new CompteBancaire("Paul McCartney", 950000));  
        creerCompte(new CompteBancaire("Ringo Starr", 20000));  
        creerCompte(new CompteBancaire("Georges Harrisson", 100000));  
    }*/ 
}
