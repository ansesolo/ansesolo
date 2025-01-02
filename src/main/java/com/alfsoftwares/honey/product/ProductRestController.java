package com.alfsoftwares.honey.product;

import com.alfsoftwares.honey.product.domain.model.ProductEntity;
import com.alfsoftwares.honey.product.domain.port.in.SearchProductAdapter;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class ProductRestController implements ProductRestControllerDocumentation {

  private final SearchProductAdapter searchProductAdapter;

  @Inject
  public ProductRestController(final SearchProductAdapter searchProductAdapter) {
    this.searchProductAdapter = searchProductAdapter;
  }

  @GetMapping(path = "/products")
  @PreAuthorize("hasRole('USER')")
  public ResponseEntity<List<ProductEntity>> getProducts(@AuthenticationPrincipal Jwt jwt) {
    //    return "Welcome on products page for "
    //            + jwt.getClaimAsString(JwtClaimNames.SUB)
    //            + " "
    //            + jwt.getClaimAsStringList("roles").get(0);

    List<ProductEntity> products = searchProductAdapter.getAllProducts();

    return ResponseEntity.ok().body(products);
  }

  @GetMapping(path = "/products/{id}")
  @PreAuthorize("hasRole('USER')")
  public ResponseEntity<ProductEntity> getProduct(@PathVariable Long id) {
    Optional<ProductEntity> product = searchProductAdapter.getProduct(id);

    return product
        .map(productEntity -> ResponseEntity.ok().body(productEntity))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
