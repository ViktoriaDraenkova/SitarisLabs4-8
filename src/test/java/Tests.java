import entity.Product;
import org.junit.jupiter.api.Test;
import service.ProductsWorker;
import service.XmlReader;
import strategy.PriceCalculateFactory;
import strategy.PromocodePriceStrategy;
import strategy.TotalPriceStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class Tests{
    @Test
    public void testTotalSum() {
        // Тестируемый класс
        ProductsWorker productsWorker = new ProductsWorker();
        productsWorker.setPriceCalculateStrategy(new TotalPriceStrategy());

        List<Product> allProducts = new ArrayList<>();
        allProducts.add(new Product(12));
        allProducts.add(new Product(13));
        allProducts.add(new Product(14));
        allProducts.add(new Product(15));
        allProducts.add(new Product(16));

        float totalPrice = productsWorker.calculatePrice(allProducts);
        // Проверяемый метод
        assertEquals(70, totalPrice, 0.00000001);
    }

    @Test
    public void testSum() {
        // Тестируемый класс
        ProductsWorker productsWorker = new ProductsWorker();
        productsWorker.setPriceCalculateStrategy(new PromocodePriceStrategy());

        List<Product> allProducts = new ArrayList<>();
        allProducts.add(new Product(12));
        allProducts.add(new Product(13));
        allProducts.add(new Product(14));
        allProducts.add(new Product(15));
        allProducts.add(new Product(16));

        float totalPrice = productsWorker.calculatePrice(allProducts);
        // Проверяемый метод
        assertEquals(63, totalPrice, 0.00000001);
    }

    @Test
    public void testReadXML() {
        XmlReader reader = new XmlReader();
        List<Product> products = reader.getAllProducts();
        assertEquals(products.size(), 4);
    }

}


