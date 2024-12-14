package com.alfsoftwares.honey.product.domain.port.in;

import com.alfsoftwares.honey.product.domain.model.ProductEntity;
import java.util.List;
import java.util.Optional;

public interface SearchProductAdapter {

  List<ProductEntity> getAllProducts();

  Optional<ProductEntity> getProduct(final Long id);
}
