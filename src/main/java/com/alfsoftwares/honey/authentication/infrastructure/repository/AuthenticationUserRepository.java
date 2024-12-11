package com.alfsoftwares.honey.authentication.infrastructure.repository;

import com.alfsoftwares.honey.authentication.domain.gateway.AuthenticatedUserGateway;
import com.alfsoftwares.honey.authentication.domain.model.AuthenticatedUser;
import jakarta.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationUserRepository implements AuthenticatedUserGateway {

  private Map<String, AuthenticatedUser> users = new HashMap<>();
  private PasswordEncoder passwordEncoder;

  @Inject
  public AuthenticationUserRepository(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
    users.put(
        "admin", new AuthenticatedUser(1L, "admin", passwordEncoder.encode("admin"), "ADMIN"));
    users.put("alf", new AuthenticatedUser(2L, "alf", passwordEncoder.encode("alf"), "USER"));
    users.put(
        "both", new AuthenticatedUser(2L, "both", passwordEncoder.encode("both"), "USER,ADMIN"));
  }

  @Override
  public AuthenticatedUser findByUsername(final String username) {
    return users.get(username);
  }
}
