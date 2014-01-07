package com.talkative.app;

import java.util.Date;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.EnableServices;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.talkative.model.Editeur;

@EnableServices(value = "jaxrs")
@RunWith(ApplicationComposer.class)
public class InscriptionEditeurTest {
  
    @Test
    public void InscriptionEditeur(){
    	WebClient client = createWebClient();
    	String login = "toto";
    	String password = "toto";
    	String email = "toto@epsi.fr";
    	Editeur editeur = new Editeur(login,password,email,new Date(System.currentTimeMillis()));
    	client.header("Accept", "application/xml").
    	path("editor").path("3").
    	post(editeur);
//    	Assert.assertEquals(422, client.getResponse().getStatus());
//    	boolean contenuAbsent = client.getResponse().getEntity().toString().contains("invalide");
//    	Assert.assertEquals(true, contenuAbsent);
    }
    
	private WebClient createWebClient() {
		WebClient client = WebClient.create("http://localhost:4204/talkative/api");
		ClientConfiguration config = WebClient.getConfig(client);
		config.getInInterceptors().add(new LoggingInInterceptor());
		config.getOutInterceptors().add(new LoggingOutInterceptor());
		return client; 
	}
    
}
