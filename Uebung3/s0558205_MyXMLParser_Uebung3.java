package java_dom_parser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyXMLParser {
	public static void main(String[]args){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("3.xml");
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("flight");
			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("flight number : " + eElement.getElementsByTagName("number").item(0).getTextContent());
					System.out.println("flight date : " + eElement.getElementsByTagName("flightdate").item(0).getTextContent());
					System.out.println("flight time : " + eElement.getElementsByTagName("flighttime").item(0).getTextContent());
					System.out.println("booking date : " + eElement.getElementsByTagName("bookingdate").item(0).getTextContent());
					System.out.println("destination : " + eElement.getElementsByTagName("destination").item(0).getTextContent());
					System.out.println("departure : " + eElement.getElementsByTagName("departure").item(0).getTextContent());
					
					NodeList nList2 = doc.getElementsByTagName("passengers");
					Node nNode2 = nList2.item(temp);
					
					System.out.println("\n \t Current Element: " + nNode2.getNodeName());
					if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement2 = (Element) nNode2;
						NodeList nList3 = doc.getElementsByTagName("passengers");
						Node nNode3 = nList3.item(temp);
						Element eElement3 = (Element)nNode3;
						NodeList value1Nodes = (eElement3).getElementsByTagName("passenger");
						int lengthofimage = value1Nodes.getLength();
						for(int i = 0; i < lengthofimage;i++){
							if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
								System.out.println("\n \t\t Current Element: passenger number = " + (i+1) );
								System.out.println("\t\t last name : " + eElement.getElementsByTagName("lastname").item(i).getTextContent());
								System.out.println("\t\t first name : " + eElement.getElementsByTagName("firtnanme").item(i).getTextContent());
								System.out.println("\t\t sex : " + eElement.getElementsByTagName("sex").item(i).getTextContent());
								System.out.println("\t\t vegeterian : " + eElement.getElementsByTagName("vegetarian").item(i).getTextContent());
								System.out.println("\t\t birthday : " + eElement.getElementsByTagName("birthdate").item(i).getTextContent());
								System.out.println("\t\t passport number : " + eElement.getElementsByTagName("passportnumber").item(i).getTextContent());
								System.out.println("\t\t seat : " + eElement.getElementsByTagName("seat").item(i).getTextContent());
								
							}
						}
						
						}

		}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
