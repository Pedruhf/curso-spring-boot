package cursojava.curso_java.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cursojava.curso_java.entities.Product;
import cursojava.curso_java.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping
  public List<Product> getAll() {
    return this.productService.getAll();
  }

  @GetMapping("/{id}")
  public Optional<Product> getById(@PathVariable Integer id) {
    return this.productService.getById(id);
  }

  @PostMapping
  public Product save(@RequestBody Product product) {
    return this.productService.save(product);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    this.productService.delete(id);
    return "Produto deletado com sucesso";
  }

  @PutMapping("/{id}")
  public Product update(@PathVariable Integer id, @RequestBody Product product) {
    return this.productService.update(id, product);
  }
}
