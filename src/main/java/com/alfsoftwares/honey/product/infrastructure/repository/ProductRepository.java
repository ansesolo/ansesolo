package com.alfsoftwares.honey.product.infrastructure.repository;

import static com.alfsoftwares.honey.product.domain.model.ProductEntity.ProductBuilder;

import com.alfsoftwares.honey.core.domain.model.Unit;
import com.alfsoftwares.honey.product.domain.model.ProductEntity;
import com.alfsoftwares.honey.product.domain.port.out.ProductGateway;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements ProductGateway {

  private Map<Long, ProductEntity> products = new HashMap<>();

  public ProductRepository() {
    products.put(1L, new ProductBuilder(1L, "POT VIDE 1KG").withMoney(Money.of(1, "EUR")).build());
    products.put(
        2L, new ProductBuilder(2L, "POT VIDE 500g").withMoney(Money.of(0.5, "EUR")).build());
    products.put(
        3L, new ProductBuilder(3L, "Barquette vide").withMoney(Money.of(0.5, "EUR")).build());
    products.put(4L, new ProductBuilder(4L, "POT MIEL 1KG").withMoney(Money.of(13, "EUR")).build());
    products.put(5L, new ProductBuilder(5L, "POT MIEL 500g").withMoney(Money.of(7, "EUR")).build());
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
