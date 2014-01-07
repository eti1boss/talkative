package com.talkative.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.EnableServices;
import org.apache.openejb.testing.Module;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.talkative.model.Article;
import com.talkative.model.Commentaire;
import com.talkative.model.CommentaireGuest;
import com.talkative.model.Editeur;
import com.talkative.repository.ArticleRepository;
import com.talkative.repository.EditorRepository;
import com.talkative.repository.MockArticleRepository;
import com.talkative.repository.MockEditorRepository;
import com.talkative.resource.TalkativeApplication;

@EnableServices(value = "jaxrs")
@RunWith(ApplicationComposer.class)
public class ArtcileCommentsTest {
//    @Module
//    public SingletonBean app() {
//        return (SingletonBean) new SingletonBean(GetCommentsService.class).localBean();
//    }
    
	@EJB
	private EditorRepository editorRepository;
	@EJB
	private ArticleRepository articleRepository;
	
	@Module
	@Classes(TalkativeApplication.class)
	public WebApp webapp() {
		return new WebApp().contextRoot("talkative");
	}

	@Module
	@Classes({MockArticleRepository.class,MockEditorRepository.class})
	public EjbJar ejb() {
		return new EjbJar();
	}
	
    @Before
    public void load(){
    	Editeur editeur1 = new Editeur("1");
		Editeur editeur2 = new Editeur("2");
		Editeur editeur3 = new Editeur("3");
		editorRepository.addEditor(editeur1);
		editorRepository.addEditor(editeur2);
		editorRepository.addEditor(editeur3);
    	Article article1 = new Article("article1", "www.epsi.com/myArticle1.html", editeur1);
		Article article2 = new Article("article2", "www.epsi.com/myArticle2.html", editeur2);
		Article article3 = new Article("article3", "www.epsi.com/myArticle3.html", editeur3);
		articleRepository.addArticle(article1);
		articleRepository.addArticle(article2);
		articleRepository.addArticle(article3);
		Commentaire comment1 = new Commentaire("Il ai nul ton narticle","pseudo1",new Date(System.currentTimeMillis()));
		article2.ajouterCommentaire(comment1);
		System.out.println();
    }
    
    /*OK*/
    @Test
    public void knownEditorAndArticleWhithoutComments(){
    	String urlArticle = "www.epsi.com/myArticle1.html";
    	String  idEditeur = "1";
    	WebClient client = createWebClient();
    	client.path("editors").path(idEditeur).
    	path("articles").path(urlArticle).
    	path("comments").get();
    	Assert.assertEquals(204, client.getResponse().getStatus());
    }
    
    /*OK*/
    @Test
    public void forbidenUser(){
    	String urlArticle = "www.epsi.com/myArticle1.html";
    	/*Test avec caractères*/
    	String  idEditeur = "xxxxx";
    	WebClient client = createWebClient();
    	client.path("editors").path(idEditeur).
    	path("articles").path(urlArticle).
    	path("comments").get();
    	Assert.assertEquals(401, client.getResponse().getStatus());
    	/*Test avec entier*/
    	client.path("editors").path("6").
    	path("articles").path(urlArticle).
    	path("comments").get();
    	Assert.assertEquals(401, client.getResponse().getStatus());
    }
    
    /*KO*/
//    @Test
//    public void addCommentToExistingArticle(){
//    	WebClient client = createWebClient();
//    	String urlArticle = "www.epsi.com/myArticle.html";
//    	String commentaireTexte = "Vas-y ton article il ai plain de fote ! Retourne a l'écaule !";
//    }
    
    /*OK*/
    @Test
    public void recupererArticleXML() {
    	WebClient client = createWebClient();
    	String urlArticle = "www.epsi.com/myArticle2.html";
    	client.header("Accept", "application/xml").
    	path("editors").path("2").
    	path("articles").path(urlArticle).
    	path("comments").get();
    	Assert.assertEquals(200, client.getResponse().getStatus());
    	boolean isValidXML = false;
		try {
			xmlIsValid(client.getResponse().getEntity().toString(), "article.xsd");
			isValidXML = true;
		} catch (IOException | SAXException e) {
			System.err.println("Erreur lors de la vérification XML");
			e.printStackTrace();
		}    
    }
    
    /*OK*/
    /*
     * Vérifier XML ***********************************************************
     */
    @Test
    public void ajouterCommentaireGuest(){
    	WebClient client = createWebClient();
    	String email = "toto@epsi.fr";
    	String pseudo = "toto";
    	String contenu = "Vas-y ton article il ai plain de fote ! Retourne a l'ecaule !";
    	CommentaireGuest comment = new CommentaireGuest(contenu,pseudo,email,new Date(System.currentTimeMillis()));
    	String urlArticle = "www.epsi.com/myArticle3.html";
    	client.header("Accept", "application/xml").
    	path("editors").path("3").
    	path("articles").path(urlArticle).
    	path("comments").
    	post(comment);
    	Assert.assertEquals(201, client.getResponse().getStatus());
    	boolean articleInsere = client.getResponse().getEntity().toString().contains("Vas-y ton article il ai plain");
    	Assert.assertEquals(true, articleInsere);
//    	boolean isValidXML = false;
//		try {
//			xmlIsValid(client.getResponse().getEntity().toString(), "article.xsd");
//			isValidXML = true;
//		} catch (IOException | SAXException e) {
//			System.err.println("Erreur lors de la vérification XML");
//			e.printStackTrace();
//		}
//		Assert.assertEquals(true, isValidXML);
    }
    
    @Test
    public void ajouterCommentaireGuestContenuVide(){
    	WebClient client = createWebClient();
    	String email = "toto@epsi.fr";
    	String pseudo = "toto";
    	String contenu = "";
    	CommentaireGuest comment = new CommentaireGuest(contenu,pseudo,email,new Date(System.currentTimeMillis()));
    	String urlArticle = "www.epsi.com/myArticle3.html";
    	client.header("Accept", "application/xml").
    	path("editors").path("3").
    	path("articles").path(urlArticle).
    	path("comments").
    	post(comment);
    	Assert.assertEquals(422, client.getResponse().getStatus());
    	boolean contenuAbsent = client.getResponse().getEntity().toString().contains("invalide");
    	Assert.assertEquals(true, contenuAbsent);
    }
    
    @Test
    public void ajouterCommentaireGuestPseudoVide(){
    	WebClient client = createWebClient();
    	String email = "toto@epsi.fr";
    	String pseudo = "";
    	String contenu = "Mon super commentaire";
    	CommentaireGuest comment = new CommentaireGuest(contenu,pseudo,email,new Date(System.currentTimeMillis()));
    	String urlArticle = "www.epsi.com/myArticle3.html";
    	client.header("Accept", "application/xml").
    	path("editors").path("3").
    	path("articles").path(urlArticle).
    	path("comments").
    	post(comment);
    	Assert.assertEquals(422, client.getResponse().getStatus());
    	boolean contenuAbsent = client.getResponse().getEntity().toString().contains("invalide");
    	Assert.assertEquals(true, contenuAbsent);
    }
    
    @Test
    public void ajouterCommentaireGuestEmailInvalide(){
    	WebClient client = createWebClient();
    	String email = "nick.samer@lol";
    	String pseudo = "Nick Samer";
    	String contenu = "Mon super commentaire";
    	CommentaireGuest comment = new CommentaireGuest(contenu,pseudo,email,new Date(System.currentTimeMillis()));
    	String urlArticle = "www.epsi.com/myArticle3.html";
    	client.header("Accept", "application/xml").
    	path("editors").path("3").
    	path("articles").path(urlArticle).
    	path("comments").
    	post(comment);
    	Assert.assertEquals(422, client.getResponse().getStatus());
    	boolean contenuAbsent = client.getResponse().getEntity().toString().contains("invalide");
    	Assert.assertEquals(true, contenuAbsent);
    }
    
	private WebClient createWebClient() {
		WebClient client = WebClient.create("http://localhost:4204/talkative/api");
		ClientConfiguration config = WebClient.getConfig(client);
		config.getInInterceptors().add(new LoggingInInterceptor());
		config.getOutInterceptors().add(new LoggingOutInterceptor());
		return client; 
	}
	
	private void xmlIsValid(String xmlString, String schemaPath) throws IOException, SAXException{
		File tmp = new File("tmp.xml");
		FileWriter fw = new FileWriter(tmp);
		fw.write(xmlString);
		fw.close();
		SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema") ;
		InputSource sourceentree = new InputSource(new FileInputStream(new File(schemaPath)));
		SAXSource sourceXSD = new SAXSource(sourceentree);
		Schema schema = factory.newSchema(sourceXSD);
		Validator validator = schema.newValidator() ;
		validator.validate(new StreamSource(tmp));
	}
}