/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.coffeecustomer.entity;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author cesi
 */
@Entity
@Table(name = "customers")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll",query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.mail=:email") 
})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="fullname")
    private String name;
    
    @Column(name="email")
    private String mail;

    public Customer(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }
   // pour que le provider JACKSON puisse désérialisé un message(corps d'entité) JSON en objet Java
    //Jackson a besoin de créé une instance avant de lui assigner les propriété du message JSON
   public Customer(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.cesi.coffeecustomer.Customer[ id=" + id + " ]";
    }
    
}
