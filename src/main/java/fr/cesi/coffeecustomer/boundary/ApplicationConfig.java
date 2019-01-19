/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.coffeecustomer.boundary;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author cesi
 * On utilise l'auto-scanning / découverte automatique des différentes ressources (root, providers...)
 * par le moteur JAX-RS. Ainsi la ressource root et l'entity provider Jackson sont automatiquement découverts parJAX-RS
 * le code automatiquement ajouté par NB configure l'ajout/l'enregistrement manuel des ressources (root, provider).
 * Par conséquent avec ce code, le provider Jackson n'est pas automatiquement découvert. Il faudrait l'enregistré manuellement.
 * D'où la "suppression" de ce code.
 * 
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application{

//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> resources = new java.util.HashSet<>();
//        addRestResourceClasses(resources);     
//        return resources;
//    }
//
//    /**
//     * Do not modify addRestResourceClasses() method.
//     * It is automatically populated with
//     * all resources defined in the project.
//     * If required, comment out calling this method in getClasses().
//     */
//    private void addRestResourceClasses(Set<Class<?>> resources) {
//        resources.add(fr.cesi.coffeecustomer.boundary.CustomerResource.class);
//    }
    
}
