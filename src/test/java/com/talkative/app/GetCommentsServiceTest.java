package com.talkative.app;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.inject.Inject;

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

import com.talkative.model.Article;
import com.talkative.model.Commentaire;
import com.talkative.model.Inscrit;
import com.talkative.repository.ArticleRepository;
import com.talkative.repository.EditorRepository;
import com.talkative.repository.MockArticleRepository;
import com.talkative.repository.MockEditorRepository;
import com.talkative.resource.TalkativeApplication;

@EnableServices(value = "jaxrs")
@RunWith(ApplicationComposer.class)
public class GetCommentsServiceTest {
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

    	Inscrit inscrit1 = new Inscrit(1, null,null,null);
		Inscrit inscrit2 = new Inscrit(2, null,null,null);
		Inscrit inscrit3 = new Inscrit(3, null,null,null);
		editorRepository.addEditor(inscrit1);
		editorRepository.addEditor(inscrit2);
		editorRepository.addEditor(inscrit3);
    	Article article1 = new Article("article1", "www.epsi.com/myArticle1.html", new ArrayList<Commentaire>(),inscrit1);
		Article article2 = new Article("article2", "www.epsi.com/myArticle2.html", new ArrayList<Commentaire>(),inscrit2);
		articleRepository.addArticle(article1);
		articleRepository.addArticle(article2);
    }

//    @Test
//    public void inscritInconnu(){
//    	String idArticle = "idArticle";
//    	int idInscrit = 0;
//        final String message = WebClient.create("http://localhost:4204")
//        		.path("/GetCommentsServiceTest/getComments/"+idInscrit+"/"+idArticle)
//        		.get(String.class);
//        assertEquals("Editeur inconnu", message);
//    }
//    
//    @Test
//    public void inscritConnuArticleInconnu(){
//    	String idArticle = "url2";
//    	int idInscrit = 1;
//        final String message = WebClient.create("http://localhost:4204").
//        		path("/GetCommentsServiceTest/getComments/"+idInscrit+"/"+idArticle).
//        		get(String.class);
//        assertEquals("Article inconnu", message);
//    }
    
    
    /*OK*/
    @Test
    public void articleWhithoutComments(){
    	String urlArticle = "www.epsi.com/myArticle1.html";
    	String  idInscrit = "1";
    	WebClient client = createWebClient();
    	client.path("editors").path(idInscrit).
    	path("articles").path(urlArticle).
    	path("comments").get();
    	Assert.assertEquals(204, client.getResponse().getStatus());
    }
    
//    @Test
//    public void inscritNonNumerique(){
//    	String idArticle = "url1";
//    	String idInscrit = "texte";
//        final String message = WebClient.create("http://localhost:4204").
//        		path("/GetCommentsServiceTest/getComments/"+idInscrit+"/"+idArticle).
//        		get(String.class);
//        assertEquals("Parametres invalides", message);
//    }
//    
	private WebClient createWebClient() {
		WebClient client = WebClient.create("http://localhost:4204/talkative/api");
		ClientConfiguration config = WebClient.getConfig(client);
		config.getInInterceptors().add(new LoggingInInterceptor());
		config.getOutInterceptors().add(new LoggingOutInterceptor());
		return client;
	}
    

}