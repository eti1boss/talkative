

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;

import com.talkative.model.Article;

/**
 * Pour générer le schéma Xml d'une classe
 * @author ttr
 *
 */
public class Schemas {
	
	public static void main(String[] args) throws JAXBException, IOException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Article.class);
		SchemaOutputResolver sor = new MySchemaOutputResolver();
		jaxbContext.generateSchema(sor);
		sor.createOutput("namespace", "article.xsd");
	}

}
