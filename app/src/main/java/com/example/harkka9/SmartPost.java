package com.example.harkka9;

import android.view.View;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class SmartPost {

    public static ArrayList<Post> posts = new ArrayList<Post>();
    public void readXML ()    {

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            String urlString = "http://iseteenindus.smartpost.ee/api/?request=destinations&country=FI&type=APT";

            Document doc = builder.parse(urlString);

            doc.getDocumentElement().normalize();
            System.out.println("Root element: "+doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getDocumentElement().getElementsByTagName("item");
            for (int i = 0; i < nList.getLength() ; i++)    {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name, city, availability, dates[];
                    int id;
                    id = Integer.parseInt(element.getElementsByTagName("place_id").item(0).getTextContent());
                    name = element.getElementsByTagName("name").item(0).getTextContent();
                    city = element.getElementsByTagName("city").item(0).getTextContent();
                    availability = element.getElementsByTagName("availability").item(0).getTextContent();
                    dates = availability.split(",");
                    posts.add(new Post(id,name,city,availability));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            System.out.println("######DONE######");
        }


    }
}
