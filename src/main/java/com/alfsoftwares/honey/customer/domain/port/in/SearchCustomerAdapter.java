package com.alfsoftwares.honey.customer.domain.port.in;

import com.alfsoftwares.honey.customer.domain.model.CustomerEntity;
import java.util.List;
import java.util.Optional;

public interface SearchCustomerAdapter {

  List<CustomerEntity> getAllCustomers();

  Optional<CustomerEntity> getCustomer(final Long id);
}
