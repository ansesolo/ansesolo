package com.alfsoftwares.honey.customer.domain.usecase;

import com.alfsoftwares.honey.customer.domain.model.CustomerEntity;
import com.alfsoftwares.honey.customer.domain.port.in.SearchCustomerAdapter;
import java.util.List;
import java.util.Optional;

import com.alfsoftwares.honey.customer.domain.port.out.CustomerGateway;
import org.springframework.stereotype.Service;

@Service
public class SearchCustomer implements SearchCustomerAdapter {

  private final CustomerGateway gateway;

  SearchCustomer(CustomerGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public List<CustomerEntity> getAllCustomers() {
    return gateway.findAll();
  }

  @Override
  public Optional<CustomerEntity> getCustomer(final Long id) {
    return gateway.findById(id);
  }
}
