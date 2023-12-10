package service;

import entity.Product;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import strategy.FilterStrategy;
import strategy.PriceCalculateStrategy;

import java.util.ArrayList;
import java.util.List;

public class ProductsWorker {
    private PriceCalculateStrategy priceCalculateStrategy;

    public void setPriceCalculateStrategy(PriceCalculateStrategy priceCalculateStrategy) {
        this.priceCalculateStrategy = priceCalculateStrategy;
    }

    public float calculatePrice(List<Product> products) {
        return priceCalculateStrategy.calculatePrice(products);
    }
    private FilterStrategy filterStrategy;

    public void setFilterStrategy(FilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }
    public List<Product> filter(List<Product> products) {
        return filterStrategy.filter(products);
    }

}