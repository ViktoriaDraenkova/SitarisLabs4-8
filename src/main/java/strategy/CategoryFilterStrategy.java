package strategy;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryFilterStrategy implements FilterStrategy {
    private List<String> categories;
    public CategoryFilterStrategy(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public List<Product> filter(List<Product> products) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (categories.contains(product.getCategory())) {
                filteredProducts.add(product);
            }
        }

        return filteredProducts;
    }
}
