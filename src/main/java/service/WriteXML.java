package service;

import entity.Product;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteXML {
    public static void main(String[] args) throws IOException {

        BufferedReader input = null;

        try {
            input = new BufferedReader(new InputStreamReader(System.in));
            File file = new File("src/products.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("Products");
            document.appendChild(root);
            System.out.println("How many products data you want to add? : ");
            int count = Integer.parseInt(input.readLine());
            String name, category, ageConstraints, customer;
            float price;
            Element element;
            for (int i = 1; i <= count; i++) {
                System.out.println("Product " + i);
                System.out.println("Enter name : ");
                name = input.readLine();
                System.out.println("Enter category : ");
                category = input.readLine();
                System.out.println("Enter age constraints (example: 12+, 3-99, etc.): ");
                ageConstraints = input.readLine();
                System.out.println("Enter customer: ");
                customer = input.readLine();
                System.out.println("Enter price: ");
                price = Float.parseFloat(input.readLine());

                Product product = new Product(i, price, name, category, ageConstraints, customer);

                element = product.toXmlElement(document);
                root.appendChild(element);
            }

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
            System.out.println("Products have been written successfully.");

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
        }

    }

}
