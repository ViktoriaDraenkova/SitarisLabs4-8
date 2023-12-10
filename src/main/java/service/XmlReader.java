package service;

import entity.Product;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import strategy.CategoryFilterStrategy;
import strategy.PriceCalculateFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlReader {
    public List<Product> getAllProducts() {
        return allProducts;
    }

    private List<Product> allProducts;
    private PriceCalculateFactory strategyFactory;

    public float getTotalPrice() {
        ProductsWorker productsWorker = new ProductsWorker();
        productsWorker.setPriceCalculateStrategy(strategyFactory.createStrategy("total"));

        float totalPrice = productsWorker.calculatePrice(allProducts);
        return totalPrice;
    }

    public float getPriceWithPromocode() {
        ProductsWorker productsWorker1 = new ProductsWorker();
        productsWorker1.setPriceCalculateStrategy(strategyFactory.createStrategy("promocode"));

        float promoPrice = productsWorker1.calculatePrice(allProducts);
        return promoPrice;
    }

    public List<Product> getFilteredProducts() {
        ProductsWorker productsWorker2 = new ProductsWorker();
        List<String> categories = new ArrayList<>();
        categories.add("Fruits");
        productsWorker2.setFilterStrategy(new CategoryFilterStrategy(categories));
        return productsWorker2.filter(allProducts);
    }
    public List<Product> getProducts() {
        return allProducts;
    }

    public XmlReader() {
        strategyFactory = new PriceCalculateFactory();
        File file = new File("src/main/java/products.xml");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file); // парсим файл
            document.getDocumentElement().normalize();

            String rootNode = document.getDocumentElement().getNodeName();
            System.out.println("Root Element : " + rootNode);
            allProducts = getProductsData(document);

            System.out.println(allProducts);

        } catch (Exception exception) {
            System.err.println("ACHTUNG!!!");
            exception.printStackTrace();
        }
    }

    private static List<Product> getProductsData(Document document) { //deserialize
        NodeList list = document.getElementsByTagName("Product");
        int length = list.getLength();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Product gam = Product.fromXmlElement(element);
                products.add(gam);
            }
        }
        return products;
    }
}
