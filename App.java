/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Categoria;
import model.CategoriaNota;

/**
 *
 * @author Fitec
 */
public class App {
    public static void main(String... args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        List<CategoriaNota> lista = em.createNamedQuery("CategoriaNota.findByPersona")
                .setParameter(1, 3)
                .getResultList();
        
        
        em.getTransaction().commit();
        
        System.out.println(lista);
    }
}
