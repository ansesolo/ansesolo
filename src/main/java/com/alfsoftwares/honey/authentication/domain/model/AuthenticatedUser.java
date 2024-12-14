package com.alfsoftwares.honey.authentication.domain.model;

public record AuthenticatedUser(Long id, String username, String password, String roles) {

  public static String ROLE_SEPARATOR = ",";
}
