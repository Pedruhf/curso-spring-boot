package cursojava.curso_java.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursojava.curso_java.entities.Product;
import cursojava.curso_java.repositories.ProductRepository;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepo;

  public List<Product> getAll() {
    return this.productRepo.getAll();
  }

  public Optional<Product> getById(Integer id) {
    return this.productRepo.getById(id);
  }

  public Product save(Product product) {
    return this.productRepo.save(product);
  }

  public void delete(Integer id) {
    this.productRepo.delete(id);
  }

  public Product update(Integer Id, Product product) {
    product.setId(Id);
    return this.productRepo.update(product);
  }
}
