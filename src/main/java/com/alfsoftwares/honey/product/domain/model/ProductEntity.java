package com.alfsoftwares.honey.product.domain.model;

import com.alfsoftwares.honey.core.domain.model.NamedEntity;
import com.alfsoftwares.honey.core.domain.model.Unit;
import java.math.BigDecimal;

public class ProductEntity extends NamedEntity {

  private Unit unit = Unit.UNIT;
  private BigDecimal defaultPrice;

  private ProductEntity(ProductBuilder builder) {
    this.setId(builder.id);
    this.setName(builder.name);
    this.unit = builder.unit;
    this.defaultPrice = builder.defaultPrice;
  }

  public Unit getUnit() {
    return unit;
  }

  public void setUnit(final Unit unit) {
    this.unit = unit;
  }

  public BigDecimal getDefaultPrice() {
    return defaultPrice;
  }

  public void setDefaultPrice(final BigDecimal defaultPrice) {
    this.defaultPrice = defaultPrice;
  }

  public static class ProductBuilder {

    private final long id;
    private final String name;
    private Unit unit = Unit.UNIT;
    private BigDecimal defaultPrice = BigDecimal.valueOf(0L);

    public ProductBuilder(long id, String name) {
      this.id = id;
      this.name = name;
    }

    public ProductBuilder withUnit(Unit unit) {
      this.unit = unit;
      return this;
    }

    public ProductBuilder withPrice(BigDecimal defaultPrice) {
      this.defaultPrice = defaultPrice;
      return this;
    }

    public ProductEntity build() {
      return new ProductEntity(this);
    }
  }
}
