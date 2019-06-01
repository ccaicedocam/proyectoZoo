
package co.edu.konrad.zoo.logic;

import co.edu.konrad.zoo.entities.ShowEntity;
import co.edu.konrad.zoo.persistence.ShowPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Cristian
 */
@Stateless
public class ShowLogic {
    
    @Inject
    private ShowPersistence persistence;
    
    public List<ShowEntity> obtenershowes(){
        List<ShowEntity> showes = persistence.encontrarTodo();
        return showes;
    }
    
    /**
     * Obtener show por su id
     * @param id
     * @return ShowEntity
     */
    public ShowEntity obtenershow(Long id){
        ShowEntity show = persistence.encontrarPorId(id);
        if(show == null){
            throw new IllegalArgumentException("El show solicitado NO existe");
        }
        return show;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear un show
     * @param showCrear
     * @return 
     */
    public ShowEntity crearshow(ShowEntity showCrear){
        persistence.insertar(showCrear);
        return showCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar un show
     * @param id
     * @param showActualizar
     * @return show actualizado
     */
    public ShowEntity actualizarShow (Long id, ShowEntity showActualizar){
        ShowEntity productoUpdate = persistence.actualizar(showActualizar);
        return productoUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto show
     * @param id 
     */
    public void eliminarShow(Long id){
        persistence.eliminar(id);
    }
    
}