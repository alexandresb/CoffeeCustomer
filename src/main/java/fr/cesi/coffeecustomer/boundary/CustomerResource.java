/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.coffeecustomer.boundary;

import fr.cesi.coffeecustomer.control.CustomerService;
import fr.cesi.coffeecustomer.entity.Customer;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author cesi
 */
@Path("customers")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
    
    @Inject
    private CustomerService customerService;

    
    @GET
    public Response getCustomers() {
        //Normalement il faut utiliser le type GenericType pour mapper une liste typée dans la réponse
        //cependant le retour de List<T> fonctionne avec Payara Micro 4&5
       // return Response.ok(customerService.findCustomers()).build();
        return Response.ok(new GenericEntity<List<Customer>>(customerService.findCustomers()){}).build();
    }
    
    
    //fonctionnalité ajoutée - non présente dans la vidéo
    @GET
    @Path("{email}")
    public Response getCustomerByEmail(@PathParam("email")String email ){
        Customer c = customerService.findCustomerByEmail(email); 
        if (c==null) return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(c).build();
    }

    
    @POST
    public Response createCustomer(Customer newCustomer) {
        return Response.ok(customerService.createCustomer(newCustomer)).build();
    }
}
