package com.alfsoftwares.honey.customer.domain.port.out;

import com.alfsoftwares.honey.customer.domain.model.CustomerEntity;
import java.util.List;
import java.util.Optional;

public interface CustomerGateway {

  List<CustomerEntity> findAll();

  Optional<CustomerEntity> findById(final Long id);
}
