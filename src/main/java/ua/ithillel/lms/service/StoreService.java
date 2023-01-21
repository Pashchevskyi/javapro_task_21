package ua.ithillel.lms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.lms.exception.ProductNotFoundException;
import ua.ithillel.lms.model.Product;
import ua.ithillel.lms.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class StoreService {

  private final ProductRepository productRepository;

  public void buy() {
    try {
      System.out.println("Initially:");
      System.out.println(productRepository);
      Product product1 = productRepository.getProductById(1);
      System.out.println("The first product I will add to my cart:");
      System.out.println(product1);
      Cart cart = new Cart(productRepository);
      boolean addedToCart = cart.addProduct(product1);
      if (addedToCart) {
        System.out.println("My cart after adding:");
        System.out.println(cart);
        System.out.println("After adding to cart:");
        System.out.println(productRepository);
      }
      Product product5 = productRepository.getProductById(5);
      System.out.println("Then I will add to my cart the following product:");
      System.out.println(product5);
      addedToCart = cart.addProduct(product5);
      if (addedToCart) {
        System.out.println("My cart after adding:");
        System.out.println(cart);
        System.out.println("After adding to cart:");
        System.out.println(productRepository);
      }
      System.out.println("Than I decide not to buy the latest product I added:");
      boolean removedFromCart = cart.removeProduct(5);
      if (removedFromCart) {
        System.out.println("My cart after deleting:");
        System.out.println(cart);
        System.out.println("After deleting from cart:");
        System.out.println(productRepository);
      }
    } catch (ProductNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }
}
