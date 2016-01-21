/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasvarias;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelos.Departamento;
import modelos.Municipio;
import modelospropios.MunicipioPropio;

/**
 *
 * @author Fitec
 */
public class PruebaJPA {
    public static void main(String[] args){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebasVariasPU");
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Municipio> lista = em.createNamedQuery("municipio.concat")
                .getResultList();
        System.out.println(lista.size());
        for(Municipio municipio:lista){
            System.out.println(municipio.getMunicipioCodigo()+municipio.getMunicipioNombre());
        }   
        em.getTransaction().commit();
    }
}
