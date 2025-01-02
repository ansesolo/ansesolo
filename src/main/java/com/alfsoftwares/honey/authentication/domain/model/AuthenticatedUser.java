package com.alfsoftwares.honey.authentication.domain.model;

/**
 * Entité permettant de stocker le username, password et role. La première connextion permet de
 * contrôler si le mot de passe est correct. On génère ensuite un token qui contiendra le username
 * et le rôle pour gérer les droits.
 */
public record AuthenticatedUser(Long id, String username, String password, String roles) {

  public static String ROLE_SEPARATOR = ",";
}
