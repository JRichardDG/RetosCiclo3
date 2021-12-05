/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.gov.mintic.g43.reto3MinticG43.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Library implements Serializable {
    /*
    *
    *Definicion de la tabla
    */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 250)
    private String name;
    @Column(length = 45)
    private String target;
    private Integer capacity;
    @Column(length = 250)
    private String description;
    @ManyToOne
    @JoinColumn(name="category")
    @JsonIgnoreProperties("libs")
    private Category category;
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="lib")
    @JsonIgnoreProperties({"category","lib","client"})
    private List<Message> messages;
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="lib")
    @JsonIgnoreProperties("lib")
    private List<Reservation> reservations;
    
    /*
    *
    *Constructor
    */
    public Library(Long id, String target, Integer capacity, Category category, String name, String description) {
        this.id = id;
        this.target = target;
        this.capacity = capacity;
        this.category = category;
        this.name = name;
        this.description = description;
        /*this.message = new String [2];
        this.reservations = new String [2];*/
    }

    /*
    *
    *Constructor vacio
    */
    public Library() {
    }

    /*
    *
    *metodos
    */
    public Long getId() {
        return id;
    }
    //set id
    public void setId(Long id) {
        this.id = id;
    }
    //get target
    public String getTarget() {
        return target;
    }
    //set target
    public void setTarget(String target) {
        this.target = target;
    }
    //get capacity
    public Integer getCapacity() {
        return capacity;
    }
    //set capacity
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    //get category
    public Category getCategory() {
        return category;
    }
    //set category
    public void setCategory(Category category) {
        this.category = category;
    }
    //get name
    public String getName() {
        return name;
    }
    //set name
    public void setName(String name) {
        this.name = name;
    }
    //get des
    public String getDescription() {
        return description;
    }
    //set des
    public void setDescription(String description) {
        this.description = description;
    }
    //set reser

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
       
    
    //metodo hashcode
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    //metodo equals
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Library)) {
            return false;
        }
        Library other = (Library) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    //metodo tostring
    @Override
    public String toString() {
        return "co.gov.mintic.g43.reto3MinticG43.entidades.Library[ id=" + id + " ]";
    }
    
}
