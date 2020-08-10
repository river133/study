package java设计模式.适配器模式;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXML {
    public static Object getObject(){
        try {
        DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dfactory.newDocumentBuilder();
            Document doc;
//             doc = builder.parse(new File("\\src\\main\\java\\java设计模式\\适配器模式\\config.xml"));
             doc = builder.parse(
                     new File("D:\\code\\IdeaProjects\\study\\src\\main\\java\\java设计模式\\适配器模式\\config.xml"));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = "java设计模式.适配器模式."+ classNode.getNodeValue();
            Class<?> c = Class.forName(cName);
            Object obj = c.newInstance();
            System.out.println(c);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
