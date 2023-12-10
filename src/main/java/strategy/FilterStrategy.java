package strategy;

import entity.Product;

import java.util.List;

public interface FilterStrategy  {
    List<Product> filter(List<Product> items);

}
