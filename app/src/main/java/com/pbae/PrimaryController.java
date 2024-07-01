package com.pbae;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.pbae.utils.XMLUtils;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PrimaryController {

    private Stage stage;

    public void setStage(final Stage stage)
    {
        this.stage = stage;
    }

    @FXML
    private Button loadMapButton;

    @FXML
    private void loadMap() throws IOException, ParserConfigurationException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("choose the map");
        File mapFile = fileChooser.showOpenDialog(stage);

        if (mapFile != null)
        {
            Document doc = XMLUtils.parseFile(mapFile);
            int a = 5;
            // Obtenez toutes les balises Placemark
            NodeList nList = doc.getElementsByTagName("Placemark");

            // Parcourez tous les éléments Placemark
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // Affichez les détails de chaque Placemark
                    System.out.println("Placemark name: " + getTagValue("name", eElement));
                    System.out.println("Placemark description: " + getTagValue("description", eElement));
                    System.out.println("Placemark coordinates: " + getCoordinates(eElement));
                }
            }
        }
    }

     // Méthode pour obtenir la valeur d'un tag
     private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    // Méthode pour obtenir les coordonnées d'un Placemark
    private static String getCoordinates(Element element) {
        NodeList nodeList = element.getElementsByTagName("coordinates");
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return "No coordinates found";
    }


}
