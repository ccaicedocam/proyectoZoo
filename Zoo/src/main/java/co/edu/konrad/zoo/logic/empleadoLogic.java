/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.logic;

import co.edu.konrad.zoo.entities.listaEmpleados;
import co.edu.konrad.zoo.persistence.empleadoPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ASUS-PC
 */
public class empleadoLogic {
     @Inject
    private empleadoPersistence persistence;
    
    public List<listaEmpleados> obtenerAnimales(){
        List<listaEmpleados> animales = persistence.encontrarTodo();
        return animales;
    }
    
    /**
     * Obtener Animal por su id
     * @param id
     * @return AnimalEntity
     */
    public listaEmpleados obtenerAnimal(Long id){
        listaEmpleados animal = persistence.encontrarPorId(id);
        if(animal == null){
            throw new IllegalArgumentException("El animal solicitado NO existe");
        }
        return animal;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear un Animal
     * @param crearEmpleado
     * @return 
     */
    public listaEmpleados crearAnimal(listaEmpleados crearEmpleado){
        persistence.insertar(crearEmpleado);
        return crearEmpleado;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar un Animal
     * @param id
     * @param actualizarEmpleado
     * @return animal actualizado
     */
    public listaEmpleados actualizarAnimal (Long id, listaEmpleados actualizarEmpleado){
        listaEmpleados productoUpdate = persistence.actualizar(actualizarEmpleado);
        return productoUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto animal
     * @param id 
     */
    public void eliminarEmpleado(Long id){
        persistence.eliminar(id);
    }
     
}
