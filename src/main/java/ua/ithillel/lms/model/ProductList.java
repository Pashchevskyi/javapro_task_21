package ua.ithillel.lms.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductList {

  @Getter
  private final List<Product> products;

  public ProductList() {
    this.products = new ArrayList<>();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ID\tName\tPrice\n");
    for (Product product : products) {
      sb.append(product.getId());
      sb.append("\t");
      sb.append(product.getName());
      sb.append("\t");
      sb.append(String.format("%.2f", product.getPrice()));
      sb.append("\n");
    }
    return sb.toString();
  }
}
