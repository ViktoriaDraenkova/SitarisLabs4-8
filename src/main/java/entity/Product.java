package entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Product {
    private int id;
    private String name;
    private String category;
    private String ageConstraint;
    private String customer;
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product(int id, float price, String name, String category, String ageConstraint, String customer) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.category = category;
        this.ageConstraint = ageConstraint;
        this.customer = customer;
    }

    public Product() {

    }

    public Product(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAgeConstraint() {
        return ageConstraint;
    }

    public void setAgeConstraint(String ageConstraint) {
        this.ageConstraint = ageConstraint;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Product [id:" + getId() + ", name: " + getName() + ", categoty: " + getCategory() + ", age constraint: " + getAgeConstraint() + ", customer: " + getCustomer() + "]";
    }

    public static Product fromXmlElement(Element element) {//deserialize
        int id = Integer.parseInt(element.getAttribute("id"));
        String name = getProductDetails(element, "name");
        float price = Float.parseFloat(getProductDetails(element, "price"));
        String category = getProductDetails(element, "category");
        String ageConstraint = getProductDetails(element, "ageConstraint");
        String customer = getProductDetails(element, "customer");
        return new Product(id, price, name, category, ageConstraint, customer);
    }

    private static String getProductDetails(Element element, String property) {
        String value = element.getElementsByTagName(property).item(0).getTextContent();
        return value;
    }

    public Element toXmlElement(Document document) {//serialize
        Element element = document.createElement("Product");
        element.setAttribute("id", String.valueOf(id));
        Element name = getPropertyNode("name", document, getName());
        element.appendChild(name);
        Element category = getPropertyNode("category", document, getCategory());
        element.appendChild(category);
        Element ageConstraint = getPropertyNode("ageConstraint", document, getAgeConstraint());
        element.appendChild(ageConstraint);
        Element customer = getPropertyNode("customer", document, getCustomer());
        element.appendChild(customer);
        Element price = getPropertyNode("price", document, String.valueOf(getPrice()));
        element.appendChild(price);
        return element;
    }

    private static Element getPropertyNode(String property, Document document, String value) {
        Element element = document.createElement(property);//create xml element (tag)
        element.setTextContent(value);
        return element;
    }

}