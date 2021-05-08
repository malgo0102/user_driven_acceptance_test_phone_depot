// Parser from https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParser {

    public static void main(String[] args) {

        try {
            File inputFile = new File("src/main/resources/message.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("message");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("From user : "
                            + eElement.getElementsByTagName("fromUser")
                            .item(0)
                            .getTextContent());
                    System.out.println("To user : "
                            + eElement
                            .getElementsByTagName("toUser")
                            .item(0)
                            .getTextContent());
                    System.out.println("Send From Location : "
                            + eElement
                            .getElementsByTagName("sendFromLocation")
                            .item(0)
                            .getTextContent());
                    System.out.println("Send To Location : "
                            + eElement
                            .getElementsByTagName("sendToLocation")
                            .item(0)
                            .getTextContent());
                    System.out.println("Item : "
                            + eElement
                            .getElementsByTagName("item")
                            .item(0)
                            .getTextContent());
                    System.out.println("Quantity : "
                            + eElement
                            .getElementsByTagName("quantity")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}