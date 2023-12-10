package strategy;

import entity.Product;

import java.util.List;

public class PromocodePriceStrategy implements PriceCalculateStrategy{
    @Override
    public float calculatePrice(List<Product> products) {
        float totalPrice = 0.0f;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice * 0.9f;
    }
}
