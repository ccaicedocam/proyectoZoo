/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.persistence;

import co.edu.konrad.zoo.entities.comidaAnimalEntity;
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
public class comidaAnimalPersistence {
    
    @PersistenceContext (unitName = "zoopu")
    protected EntityManager ez;
    
    public List<comidaAnimalEntity> encontrarTodo(){
        Query todos = ez.createQuery("select p from comidaAnimalEntity p");
        return todos.getResultList();
    }
    
    //permite traer en productoEntity el dato de la tabla por medio del id
    public comidaAnimalEntity encontrarPorId(Long id){
      return ez.find(comidaAnimalEntity.class, id);
    }
    
    //permite insertar datos a la tabla prodcuto retornando el mismo producto
    public comidaAnimalEntity insertar(comidaAnimalEntity entity){
     ez.persist(entity);
     return entity;
    }
    
    //permite acutalizar el dato en la tabla
    public comidaAnimalEntity actualizar(comidaAnimalEntity entity){
     return ez.merge(entity);
    }
    
    public void eliminar(Long id){
      comidaAnimalEntity comidaAnimalEliminar = ez.find(comidaAnimalEntity.class, id);
      ez.remove(comidaAnimalEliminar);
    }
}
