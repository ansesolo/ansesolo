package com.alfsoftwares.honey.core.domain.model;

import jakarta.annotation.Generated;

public abstract class BaseEntity {

  @Generated({})
  private long id;

  public long getId() {
    return id;
  }

  public void setId(final long id) {
    this.id = id;
  }
}
