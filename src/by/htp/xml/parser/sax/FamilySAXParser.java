package by.htp.xml.parser.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import by.htp.xml.entity.Family;

public class FamilySAXParser {
	
	public static void main(String[] args) {		
		try {
			parseFamilyXml();
		} catch (FamilyParserException e) {
			e.printStackTrace();
		}		
	}	
	
	public static void parseFamilyXml() throws FamilyParserException{
		try {
			SAXParserFactory parserFactory = SAXParserFactory.newInstance();
			SAXParser parser = parserFactory.newSAXParser();
			
			FamilyDefaultHandler familyDefaultHandler = new FamilyDefaultHandler();
			parser.parse("resources/family.xml", familyDefaultHandler);
			
			for(Family family: familyDefaultHandler.getFamilyList()) {
				System.out.println(family);
			}						
		} catch (SAXException |  ParserConfigurationException | IOException e) {
			throw new FamilyParserException("Some problem during SAX parsing", e);
		}		
	}

}