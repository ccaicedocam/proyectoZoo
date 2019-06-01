/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.persistence;

import co.edu.konrad.zoo.entities.AnimalEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cristian_caicedo
 */
@Stateless
public class AnimalPersistence {
    
    @PersistenceContext (unitName = "zoopu")
    protected EntityManager ez;
    
    public List<AnimalEntity> encontrarTodo(){
        Query todos = ez.createQuery("select p from AnimalEntity p");
        return todos.getResultList();
    }
    
    //permite traer en productoEntity el dato de la tabla por medio del id
    public AnimalEntity encontrarPorId(Long id){
      return ez.find(AnimalEntity.class, id);
    }
    
    //permite insertar datos a la tabla prodcuto retornando el mismo producto
    public AnimalEntity insertar(AnimalEntity entity){
     ez.persist(entity);
     return entity;
    }
    
    //permite acutalizar el dato en la tabla
    public AnimalEntity actualizar(AnimalEntity entity){
     return ez.merge(entity);
    }
    
    public void eliminar(Long id){
      AnimalEntity animalEliminar = ez.find(AnimalEntity.class, id);
      ez.remove(animalEliminar);
    }
}
