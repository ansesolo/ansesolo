package com.alfsoftwares.honey.product;

import com.alfsoftwares.honey.product.application.model.ProductEntityModel;
import com.alfsoftwares.honey.product.domain.model.ProductEntity;
import com.alfsoftwares.honey.product.domain.port.in.SearchProductAdapter;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@ExposesResourceFor(ProductEntity.class)
@RequestMapping(path = "/api/products")
public class ProductRestController implements ProductRestControllerDocumentation {

  private final SearchProductAdapter searchProductAdapter;

  @Inject
  public ProductRestController(final SearchProductAdapter searchProductAdapter) {
    this.searchProductAdapter = searchProductAdapter;
  }

  @GetMapping
  @PreAuthorize("hasRole('USER')")
  public ResponseEntity<List<ProductEntityModel>> getProducts() {
    List<ProductEntity> products = searchProductAdapter.getAllProducts();

    return ResponseEntity.ok().body(products.stream().map(ProductEntityModel::new).toList());
  }

  @GetMapping(path = "/{id}")
  @PreAuthorize("hasRole('USER')")
  public ResponseEntity<ProductEntityModel> getProduct(@PathVariable Long id) {
    Optional<ProductEntity> product = searchProductAdapter.getProduct(id);

    return product
        .map(entity -> ResponseEntity.ok().body(new ProductEntityModel(entity)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
