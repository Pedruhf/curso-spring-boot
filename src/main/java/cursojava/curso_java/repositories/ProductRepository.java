package cursojava.curso_java.repositories;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import cursojava.curso_java.entities.Product;

@Repository
public class ProductRepository {
  private List<Product> products = new ArrayList<Product>();
  private Integer lastId = 1;

  /**
   * 
   * @return List<Product>
   */
  public List<Product> getAll() {
    return this.products;
  }

  public Optional<Product> getById(Integer id) {
    return this.products
      .stream()
      .filter(product -> product.getId() == id)
      .findFirst();
  }

  public Product save(Product product) {
    product.setId(this.lastId);
    this.products.add(product);
    this.lastId++;
    return product;
  }

  public void delete(Integer id) {
    this.products.removeIf(product -> product.getId() == id);
  }

  public Product update(Product product) {
    Optional<Product> foundedProduct = getById(product.getId());
    if (foundedProduct.isEmpty()) {
      throw new InputMismatchException("Produto nao encontrado");
    }

    delete(product.getId());
    this.products.add(product);
    return product;
  }
}
