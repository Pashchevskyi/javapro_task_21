package ua.ithillel.lms.repository;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.ithillel.lms.exception.ProductNotFoundException;
import ua.ithillel.lms.model.Product;
import ua.ithillel.lms.model.ProductList;

@RequiredArgsConstructor
@Repository
public class ProductRepository {

  @Autowired
  @Getter
  private final ProductList productList;

  public List<Product> getProducts() {
    return productList.getProducts();
  }

  /**
   * Returns Product instance by transferred id or throws exception if Product has NOT been found
   *
   * @param id Product ID (long integer)
   * @return Product if it has been found
   * @throws ProductNotFoundException if Product with id has NOT been found
   */
  public Product getProductById(long id) throws ProductNotFoundException {
    return productList.getProducts().stream().filter((product) -> product.getId() == id).findFirst()
        .orElseThrow(() -> new ProductNotFoundException(id));
  }

  @Override
  public String toString() {
    return "Assortment:\n" + productList;
  }
}
