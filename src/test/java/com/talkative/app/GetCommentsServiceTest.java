package com.talkative.app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.SingletonBean;
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.EnableServices;
import org.apache.openejb.testing.Module;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.talkative.model.Article;
import com.talkative.model.Commentaire;
import com.talkative.model.GestionArticles;
import com.talkative.model.GestionInscrits;
import com.talkative.model.Inscrit;
import com.talkative.repository.MockEditorRepository;
import com.talkative.resource.TalkativeApplication;

@EnableServices(value = "jaxrs")
@RunWith(ApplicationComposer.class)
public class GetCommentsServiceTest {
//    @Module
//    public SingletonBean app() {
//        return (SingletonBean) new SingletonBean(GetCommentsService.class).localBean();
//    }
    
	@Module
	@Classes(TalkativeApplication.class)
	public WebApp webapp() {
		return new WebApp().contextRoot("talkative");
	}

	@Module
	@Classes(MockEditorRepository.class)
	public EjbJar ejb() {
		return new EjbJar();
	}
    
    @Before
    public void load(){
    	Inscrit inscrit1 = new Inscrit(1, null,null,null);
		Inscrit inscrit2 = new Inscrit(2, null,null,null);
		Inscrit inscrit3 = new Inscrit(3, null,null,null);
		GestionInscrits.listInscrits.add(inscrit1);
		GestionInscrits.listInscrits.add(inscrit2);
		GestionInscrits.listInscrits.add(inscrit3);
    	Article article1 = new Article("article1", "url1", new ArrayList<Commentaire>(),inscrit1);
		Article article2 = new Article("article2", "url2", new ArrayList<Commentaire>(),inscrit2);
		GestionArticles.listArticles.add(article1);
		GestionArticles.listArticles.add(article2);
    }

    @Test
    public void inscritInconnu(){
    	String idArticle = "idArticle";
    	int idInscrit = 0;
        final String message = WebClient.create("http://localhost:4204")
        		.path("/GetCommentsServiceTest/getComments/"+idInscrit+"/"+idArticle)
        		.get(String.class);
        assertEquals("Editeur inconnu", message);
    }
    
    @Test
    public void inscritConnuArticleInconnu(){
    	String idArticle = "url2";
    	int idInscrit = 1;
        final String message = WebClient.create("http://localhost:4204").
        		path("/GetCommentsServiceTest/getComments/"+idInscrit+"/"+idArticle).
        		get(String.class);
        assertEquals("Article inconnu", message);
    }
    
    
    /*OK*/
    @Test
    public void articleWhithoutComments(){
    	String urlArticle = "www.epsi.com/myArticle.html";
    	String  idInscrit = MockEditorRepository.UNKNOWN_EDITOR;
    	WebClient client = createWebClient();
    	client.path("editors").path(idInscrit).
    	path("articles").path(urlArticle).
    	path("comments").get();
    	Assert.assertEquals(403, client.getResponse().getStatus());
    }
    
    @Test
    public void inscritNonNumerique(){
    	String idArticle = "url1";
    	String idInscrit = "texte";
        final String message = WebClient.create("http://localhost:4204").
        		path("/GetCommentsServiceTest/getComments/"+idInscrit+"/"+idArticle).
        		get(String.class);
        assertEquals("Parametres invalides", message);
    }
    
	private WebClient createWebClient() {
		WebClient client = WebClient.create("http://localhost:4204/talkative/api");
		ClientConfiguration config = WebClient.getConfig(client);
		config.getInInterceptors().add(new LoggingInInterceptor());
		config.getOutInterceptors().add(new LoggingOutInterceptor());
		return client;
	}
    

}