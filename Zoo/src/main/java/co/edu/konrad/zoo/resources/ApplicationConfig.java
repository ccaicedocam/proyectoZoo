/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.resources;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author jorge
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application{
    
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new HashSet<>();
        addRestResourceClasses(resources);
        return resources;      
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(co.edu.konrad.zoo.resources.AnimalResources.class);
        resources.add(co.edu.konrad.zoo.resources.ComidaAnimalResources.class);
        resources.add(co.edu.konrad.zoo.resources.comidaResources.class);
        resources.add(co.edu.konrad.zoo.resources.cuidadoAnimalResources.class);
        resources.add(co.edu.konrad.zoo.resources.ratingResources.class);
        resources.add(co.edu.konrad.zoo.resources.showAnimalResources.class);
        resources.add(co.edu.konrad.zoo.resources.showResources.class);
    }
}
