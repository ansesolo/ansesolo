package com.alfsoftwares.honey.customer.infrastructure.repository;

import static com.alfsoftwares.honey.customer.domain.model.CustomerEntity.CustomerBuilder;

import com.alfsoftwares.honey.customer.domain.model.CustomerEntity;
import com.alfsoftwares.honey.customer.domain.port.out.CustomerGateway;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository implements CustomerGateway {

  private final Map<Long, CustomerEntity> customers = new HashMap<>();

  public CustomerRepository() {
    customers.put(
        1L,
        new CustomerBuilder(1L)
            .withIdentity("fabien", "allemand")
            .withEmail("test@email.com")
            .withPhone("0625445898")
            .withAddress("20 rue claire", "69400", "anse")
            .build());
    customers.put(
        2L,
        new CustomerBuilder(2L)
            .withIdentity("Laurent", "marcon")
            .withEmail("toto@yahoo.fr")
            .build());
    customers.put(
        3L,
        new CustomerBuilder(3L).withIdentity("Serge", "moulin").withPhone("0632558965").build());
    customers.put(
        4L,
        new CustomerBuilder(4L)
            .withIdentity("France", "saez")
            .withAddress("12 rue lorin", "43370", "cussac sur loire")
            .build());
    customers.put(
        5L,
        new CustomerBuilder(5L)
            .withIdentity("Jean", "peuplus")
            .withEmail("azertyuiop@outlook.fr")
            .withPhone("0632558895")
            .build());
    customers.put(6L, new CustomerBuilder(6L).build());
    customers.put(7L, new CustomerBuilder(7L).withIdentity("alain", "terieur").build());
  }

  @Override
  public List<CustomerEntity> findAll() {
    return customers.values().stream().toList();
  }

  @Override
  public Optional<CustomerEntity> findById(final Long id) {
    return Optional.ofNullable(customers.get(id));
  }
}
