/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.coffeecustomer.control;

import fr.cesi.coffeecustomer.entity.Customer;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author cesi
 * l'EM n'est pas thread-safe, il ne doit donc pas injecté dans un bean dont l'instance 
 * est accessible par plusieurs threads simultanément. 
 * 
 * la base n'a pas de contrainte d'unicité sur la colonne des emails.
 * le code métier de ce service ne gère pas non plus l'unicité des emails.
 * Par conséquent, il peut y avoir des doublons de mail lorsqu'on crée un compte en invocant
 * directement ce microservice.
 */

@RequestScoped
public class CustomerService {
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
   
    /**
     * Creates a new instance of CustomerService
     */
    public CustomerService() {
    }
    
    public List<Customer> findCustomers(){
        TypedQuery<Customer> query= em.createNamedQuery("Customer.findAll",Customer.class);
        List<Customer> customers = query.getResultList();
        for(Customer c : customers){
            System.out.println(c.getId()+" "+c.getName());
        }
        return customers;
           
    }
    
    public Customer findCustomerByEmail(String email){
        TypedQuery<Customer> query= em.createNamedQuery("Customer.findByEmail",Customer.class);
        query.setParameter("email", email);
        try{
            Customer customer = query.getSingleResult();
            return customer;
        }catch(NoResultException nre){
            return null;
        }
        
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public Customer createCustomer (Customer customer){
        em.persist(customer);
        return customer;
    }
    
}
