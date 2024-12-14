package com.alfsoftwares.honey.product.domain.usecase;

import com.alfsoftwares.honey.product.domain.model.ProductEntity;
import com.alfsoftwares.honey.product.domain.port.in.SearchProductAdapter;
import com.alfsoftwares.honey.product.domain.port.out.ProductGateway;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SearchProduct implements SearchProductAdapter {

  private final ProductGateway gateway;

  SearchProduct(ProductGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public List<ProductEntity> getAllProducts() {
    return gateway.findAll();
  }

  @Override
  public Optional<ProductEntity> getProduct(final Long id) {
    return gateway.findById(id);
  }
}
