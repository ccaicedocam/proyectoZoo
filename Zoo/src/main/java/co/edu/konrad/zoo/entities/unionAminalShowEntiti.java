/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author ASUS-PC
 */
public class unionAminalShowEntiti implements Serializable{
    
    @Id
    @Column (name ="id_union")
    private long idUnion;
    
    @Column (name ="id_animal")
    private long idAnimal;
    
    @Column (name ="id_show")
    private long idShow;
    
    public unionAminalShowEntiti(){
        
    }

    public long getIdUnion() {
        return idUnion;
    }

    public void setIdUnion(long idUnion) {
        this.idUnion = idUnion;
    }

    public long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public long getIdShow() {
        return idShow;
    }

    public void setIdShow(long idShow) {
        this.idShow = idShow;
    }
    
    
    
}
