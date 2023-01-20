package ua.ithillel.lms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.ithillel.lms.model.Product;

@Configuration
public class ProductConfig {

  @Bean
  public Product product1() {
    return new Product(1, "Asus", 59999.99);
  }

  @Bean
  public Product product2() {
    return new Product(2, "Acer", 49999.99);
  }

  @Bean
  public Product product3() {
    return new Product(3, "Asus Battery", 1700);
  }

  @Bean
  public Product product4() {
    return new Product(4, "Acer Battery", 1500);
  }

  @Bean
  public Product product5() {
    return new Product(5, "Luxeon UPS", 6399.99);
  }

  @Bean
  public Product product6() {
    return new Product(6, "Luxeon Voltage Corrector", 6399.99);
  }

  @Bean
  public Product product7() {
    return new Product(7, "Samsung air condition", 50590.51);
  }

  @Bean
  public Product product8() {
    return new Product(8, "Samsung refrigerator", 63999.99);
  }
}
