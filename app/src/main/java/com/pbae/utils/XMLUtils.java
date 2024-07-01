package com.pbae.utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public class XMLUtils {
    
    public static Document parseFile(final File xmlFile) throws ParserConfigurationException
    {
        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();
    
    
            Document doc = dBuilder.parse(xmlFile);
            return doc;
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
        return null;
        
    }
}
