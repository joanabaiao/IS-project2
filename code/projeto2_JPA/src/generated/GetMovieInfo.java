package generated;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class GetMovieInfo {
	
	public static Catalog get() throws JAXBException, SAXException, FileNotFoundException {
		
		JAXBContext jc;
		Catalog catalog = new Catalog();
		
		jc = JAXBContext.newInstance(Catalog.class);
	          
	    File schemaFile = new File("./files/movies.xsd");
	    SchemaFactory schmFact = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	    Schema schemaXSD = schmFact.newSchema(schemaFile);
	    Unmarshaller jaxbUnmarshaller = jc.createUnmarshaller(); 
	    jaxbUnmarshaller.setSchema(schemaXSD);
	    
	    catalog = (Catalog) jaxbUnmarshaller.unmarshal(new FileInputStream("./files/movies.xml"));

		return catalog;
	}


}