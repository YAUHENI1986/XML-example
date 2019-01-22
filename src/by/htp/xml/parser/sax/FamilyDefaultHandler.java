package by.htp.xml.parser.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.xml.entity.Child;
import by.htp.xml.entity.Family;
import by.htp.xml.entity.Father;
import by.htp.xml.entity.Hobby;
import by.htp.xml.entity.Mother;
import by.htp.xml.entity.Shedule;

public class FamilyDefaultHandler extends DefaultHandler{
	
	private List<Family> familyList = new ArrayList<Family>();
	private Family family;
	private Mother mother;
	private Father father;
	private Child child;
	private Hobby hobby;
	private Shedule shedule;
	private StringBuilder textValue, lastNode;

	@Override
	public void startDocument() throws SAXException {		
		System.out.println("start parsering Document");		
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("finish parsering Document");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		switch(qName) {
		case "family":
			family = new Family();
			family.setAdress(attributes.getValue("adress"));
			lastNode = new StringBuilder();
			lastNode.append(qName);
			break;
		case "mother":
			mother = new Mother();
			lastNode = new StringBuilder();
			lastNode.append(qName);
			break;
		case "father":
			father = new Father();
			lastNode = new StringBuilder();
			lastNode.append(qName);
			break;
		case "child":
			child = new Child();
			lastNode = new StringBuilder();
			lastNode.append(qName);
			break;
		case "hobby":
			hobby = new Hobby();
			mother.setHobby(hobby);
			break;
		case "day":
			shedule = new Shedule();
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch(qName) {
		case "family":
			familyList.add(family);
			break;
		case "mother":
			family.setMother(mother);
			break;
		case "father":
			family.setFather(father);
			break;
		case "maiden-name":
			mother.setMaideName(textValue.toString());	
			break;
		case "name":
			if(lastNode.toString().equals("mother")) {
				mother.setName(textValue.toString());
			}
			if(lastNode.toString().equals("father")) {
				father.setName(textValue.toString());
			}
			if(lastNode.toString().equals("child")) {
				child.setName(textValue.toString());
			}	
			break;
		case "surname":
			if(lastNode.toString().equals("mother")) {
				mother.setSurName(textValue.toString());
			}
			if(lastNode.toString().equals("father")) {
				father.setSurName(textValue.toString());
			}
			if(lastNode.toString().equals("child")) {
				child.setSurName(textValue.toString());
			}
			break;
		case "age":			
			if(lastNode.toString().equals("mother")) {
				mother.setAge(Integer.parseInt(textValue.toString()));
			}
			if(lastNode.toString().equals("father")) {
				father.setAge(Integer.parseInt(textValue.toString()));
			}
			if(lastNode.toString().equals("child")) {
				child.setAge(Integer.parseInt(textValue.toString()));
			}
			break;
		case "gender":
			if(lastNode.toString().equals("child")) {
				child.setGender(textValue.toString());
			}
			break;
		case "child":
			family.getChildren().add(child);
			break;
		case "title":
			hobby.setTitle(textValue.toString());
			break;
		case "timesper-week":
			hobby.setTimesperWeek(Integer.parseInt(textValue.toString()));
			break;
		case "day":
			shedule.setDay(textValue.toString());
			break;
		case "time":
			shedule.setTime(textValue.toString());
			mother.getHobby().getSheduleList().add(shedule);
			break;
		}
		
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		textValue = new StringBuilder();		
		textValue.append(ch, start, length);		
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Mother getMother() {
		return mother;
	}

	public void setMother(Mother mother) {
		this.mother = mother;
	}

	public String getTextValue() {
		return textValue.toString();
	}

	public void setTextValue(StringBuilder textValue) {
		this.textValue = textValue;
	}

	public Father getFather() {
		return father;
	}

	public void setFather(Father father) {
		this.father = father;
	}

	public List<Family> getFamilyList() {
		return familyList;
	}

	public void setFamilyList(List<Family> familyList) {
		this.familyList = familyList;
	}
	
}
