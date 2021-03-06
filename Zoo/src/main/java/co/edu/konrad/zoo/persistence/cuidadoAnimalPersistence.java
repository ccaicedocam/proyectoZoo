/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.persistence;

import co.edu.konrad.zoo.entities.cuidadoAnimalEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ASUS-PC
 */
@Stateless
public class cuidadoAnimalPersistence {
   @PersistenceContext (unitName = "zoopu")
    protected EntityManager ez;
    
    public List<cuidadoAnimalEntity> encontrarTodo(){
        Query todos = ez.createQuery("select p from cuidadoAnimalEntity p");
        return todos.getResultList();
    }
    
    //permite traer en productoEntity el dato de la tabla por medio del id
    public cuidadoAnimalEntity encontrarPorId(Long id){
      return ez.find(cuidadoAnimalEntity.class, id);
    }
    
    //permite insertar datos a la tabla prodcuto retornando el mismo producto
    public cuidadoAnimalEntity insertar(cuidadoAnimalEntity entity){
     ez.persist(entity);
     return entity;
    }
    
    //permite acutalizar el dato en la tabla
    public cuidadoAnimalEntity actualizar(cuidadoAnimalEntity entity){
     return ez.merge(entity);
    }
    
    public void eliminar(Long id){
      cuidadoAnimalEntity cuidadoAnimalEliminar = ez.find(cuidadoAnimalEntity.class, id);
      ez.remove(cuidadoAnimalEliminar);   
    } 
    
    
    
}
