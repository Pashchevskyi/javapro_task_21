package ua.ithillel.lms.configuration;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.ithillel.lms.model.Product;
import ua.ithillel.lms.model.ProductList;

@Configuration
public class ProductConfig {

  @Bean
  public ProductList productList() {
    List<Product> pl = new ArrayList<>();
    pl.add(new Product(1, "Asus", 59999.99));
    pl.add(new Product(2, "Acer", 49999.99));
    pl.add(new Product(3, "Asus Battery", 1700));
    pl.add(new Product(4, "Acer Battery", 1500));
    pl.add(new Product(5, "Luxeon UPS", 6399.99));
    pl.add(new Product(6, "Luxeon Voltage Corrector", 6399.99));
    pl.add(new Product(7, "Samsung air condition", 50590.51));
    pl.add(new Product(8, "Samsung refrigerator", 63999.99));
    return new ProductList(pl);
  }
}
