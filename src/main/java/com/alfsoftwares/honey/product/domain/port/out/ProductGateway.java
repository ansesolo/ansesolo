package com.alfsoftwares.honey.product.domain.port.out;

import com.alfsoftwares.honey.product.domain.model.ProductEntity;
import java.util.List;
import java.util.Optional;

public interface ProductGateway {

  List<ProductEntity> findAll();

  Optional<ProductEntity> findById(final Long id);
}
