/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.persistence;

import co.edu.konrad.zoo.entities.ShowAnimalEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jorge
 */
@Stateless
public class showAnimalPersistence {
    
    @PersistenceContext (unitName = "zoopu")
    protected EntityManager sa;
    
    public List<ShowAnimalEntity> encontrarTodo(){
        Query todos = sa.createQuery("select p from ShowAnimalEntity p");
        return todos.getResultList();
    }
    
    //permite traer en productoEntity el dato de la tabla por medio del id
    public ShowAnimalEntity encontrarPorId(Long id){
      return sa.find(ShowAnimalEntity.class, id);
    }
    
    public List<ShowAnimalEntity> encontrarTodos() {     
    Query q = sa.createQuery("select u from ShowAnimalEntity u");     
    return q.getResultList();   
    }
    
    //permite insertar datos a la tabla prodcuto retornando el mismo producto
    public ShowAnimalEntity insertar(ShowAnimalEntity entity){
     sa.persist(entity);
     return entity;
    }
    
    //permite acutalizar el dato en la tabla
    public ShowAnimalEntity actualizar(ShowAnimalEntity entity){
     return sa.merge(entity);
    }
    
    public void eliminar(Long id){
    ShowAnimalEntity showAnimalEliminar = sa.find(ShowAnimalEntity.class, id);
    sa.remove(showAnimalEliminar);   
    }
}
