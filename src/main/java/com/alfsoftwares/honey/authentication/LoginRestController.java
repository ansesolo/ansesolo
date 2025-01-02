package com.alfsoftwares.honey.authentication;

import com.alfsoftwares.honey.authentication.domain.usecase.CreateToken;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Pour acceder à ce controlleur il faut une authentification basique (user/password)
@SecurityRequirement(name = "Basic Authentication")
public class LoginRestController {
  private CreateToken createToken;

  public LoginRestController(CreateToken createToken) {
    this.createToken = createToken;
  }

  @PostMapping("/login")
  public String getToken(Authentication authentication) {
    return createToken.generate(authentication);
  }
}
