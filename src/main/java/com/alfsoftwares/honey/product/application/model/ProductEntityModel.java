package com.alfsoftwares.honey.product.application.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.alfsoftwares.honey.product.ProductRestController;
import com.alfsoftwares.honey.product.domain.model.ProductEntity;
import org.springframework.hateoas.EntityModel;

public class ProductEntityModel extends EntityModel<ProductEntity> {

  public ProductEntityModel(final ProductEntity entity) {
    super(entity);
    add(linkTo(methodOn(ProductRestController.class).getProduct(entity.getId())).withSelfRel());
    add(linkTo(methodOn(ProductRestController.class).getProducts()).withRel("allEntities"));
  }
}
