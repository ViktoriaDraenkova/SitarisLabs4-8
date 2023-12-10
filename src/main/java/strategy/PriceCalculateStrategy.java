package strategy;

import entity.Product;

import java.util.List;

public interface PriceCalculateStrategy {
    float calculatePrice(List<Product> products);
}
