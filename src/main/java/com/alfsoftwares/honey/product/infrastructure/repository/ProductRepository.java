package com.alfsoftwares.honey.product.infrastructure.repository;

import static com.alfsoftwares.honey.product.domain.model.ProductEntity.ProductBuilder;

import com.alfsoftwares.honey.core.domain.model.Unit;
import com.alfsoftwares.honey.product.domain.model.ProductEntity;
import com.alfsoftwares.honey.product.domain.port.out.ProductGateway;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements ProductGateway {

  private final Map<Long, ProductEntity> products = new HashMap<>();

  public ProductRepository() {
    products.put(
        1L, new ProductBuilder(1L, "POT VIDE 1KG").withPrice(BigDecimal.valueOf(100L)).build());
    products.put(
        2L, new ProductBuilder(2L, "POT VIDE 500g").withPrice(BigDecimal.valueOf(50)).build());
    products.put(
        3L, new ProductBuilder(3L, "Barquette vide").withPrice(BigDecimal.valueOf(50)).build());
    products.put(
        4L, new ProductBuilder(4L, "POT MIEL 1KG").withPrice(BigDecimal.valueOf(1300)).build());
    products.put(
        5L, new ProductBuilder(5L, "POT MIEL 500g").withPrice(BigDecimal.valueOf(700)).build());
    products.put(6L, new ProductBuilder(6L, "Barquette MIEL").build());
    products.put(7L, new ProductBuilder(7L, "MIEL").withUnit(Unit.KILO).build());
  }

  @Override
  public List<ProductEntity> findAll() {
    return products.values().stream().toList();
  }

  @Override
  public Optional<ProductEntity> findById(final Long id) {
    return Optional.ofNullable(products.get(id));
  }
}
