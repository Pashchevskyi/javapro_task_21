package ua.ithillel.lms.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.lms.exception.ProductNotFoundException;
import ua.ithillel.lms.model.Product;
import ua.ithillel.lms.model.ProductList;
import ua.ithillel.lms.repository.ProductRepository;

@Service
public class Cart {

  private final ProductRepository productRepository;

  @Autowired
  @Getter
  private final ProductList productList;

  public Cart(ProductRepository productRepository) {
    this.productRepository = productRepository;
    this.productList = new ProductList();
  }

  /**
   * Adds Product to Cart and removes it from ProductRepository
   *
   * @param product Product we are going to add
   * @return true if adding of product was successful and false otherwise
   */
  public boolean addProduct(Product product) {
    boolean isInCart = false;
    boolean isOutOfStore = false;
    if (productRepository.getProducts().contains(product)) {
      isInCart = productList.getProducts().add(product);
      isOutOfStore = productRepository.getProducts().remove(product);
    }
    return isInCart && isOutOfStore;
  }

  /**
   * Removes Product from cart and returns it in ProductRepository
   *
   * @param id (long integer) id of Product we are going to remove from cart
   * @return true if removing of Product was successful and false otherwise
   * @throws ProductNotFoundException if Product was not found in Cart
   */
  public boolean removeProduct(long id) throws ProductNotFoundException {
    boolean isOutOfCart;
    boolean isInStore = false;
    Product product = productList.getProducts().stream().filter((p) -> p.getId() == id).findFirst()
        .orElseThrow(() -> new ProductNotFoundException(id));
    isOutOfCart = productList.getProducts().remove(product);
    if (!productRepository.getProducts().contains(product)) {
      isInStore = productRepository.getProducts().add(product);
    }
    return isOutOfCart && isInStore;
  }

  @Override
  public String toString() {
    return "Cart:\n" + productList;
  }
}
