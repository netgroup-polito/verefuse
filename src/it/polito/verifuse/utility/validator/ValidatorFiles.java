package it.polito.verifuse.utility.validator;

import java.io.File;
import java.io.IOException;

import javax.validation.ValidationException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ValidatorFiles {
	private String xmlfile;
	private String xsdfile;
	
	/**
	 * Construtor to perform a validation of the file xml against the schema 
	 * @param xmlFile xml file to validate
	 * @param xsdfile schema 
	 */


	public ValidatorFiles(String xmlfile, String xsdfile) {
		this.xmlfile = xmlfile;
		this.xsdfile = xsdfile;
	}

	
	/**
	 * Validate the xml file against the schema.
	 * @return <code>true</code> if success; <code>false</code> otherwise
	 */

	public boolean validate() {
		try {
			
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(this.xsdfile));
            
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(this.xmlfile)));
            
		} catch (IOException e) {
			System.out.println("ExceptionIO: " + e.getMessage());
        	return false;
		} catch (SAXParseException e ) {
        	System.out.println("Error SaxParser - Line:Col - [" + e.getLineNumber() + ":" + e.getColumnNumber() + "]: \n" + e.getMessage());
        	return false;
		} catch (SAXException e ) {
        	System.out.println("ExceptionSAX: "+e.getMessage() );
        	return false;
		} catch (Exception e) {
			System.out.println("ExceptionGeneric: "+e.getMessage());
			return false;
		}
        return true;
	}

	

}
