package com.alfsoftwares.honey.product.domain.model;

import com.alfsoftwares.honey.core.domain.model.NamedEntity;
import com.alfsoftwares.honey.core.domain.model.Unit;
import javax.money.MonetaryAmount;
import org.javamoney.moneta.Money;

public class ProductEntity extends NamedEntity {

  private Unit unit = Unit.UNIT;
  private MonetaryAmount defaultPrice;

  private ProductEntity(ProductBuilder builder) {
    this.setName(builder.name);
    this.unit = builder.unit;
    this.defaultPrice = getDefaultPrice();
  }

  public Unit getUnit() {
    return unit;
  }

  public void setUnit(final Unit unit) {
    this.unit = unit;
  }

  public MonetaryAmount getDefaultPrice() {
    return defaultPrice;
  }

  public void setDefaultPrice(final MonetaryAmount defaultPrice) {
    this.defaultPrice = defaultPrice;
  }

  public static class ProductBuilder {

    private final long id;
    private final String name;
    private Unit unit = Unit.UNIT;
    private MonetaryAmount defaultPrice = Money.of(0, "EUR");

    public ProductBuilder(long id, String name) {
      this.id = id;
      this.name = name;
    }

    public ProductBuilder withUnit(Unit unit) {
      this.unit = unit;
      return this;
    }

    public ProductBuilder withMoney(MonetaryAmount defaultPrice) {
      this.defaultPrice = defaultPrice;
      return this;
    }

    public ProductEntity build() {
      return new ProductEntity(this);
    }
  }
}
