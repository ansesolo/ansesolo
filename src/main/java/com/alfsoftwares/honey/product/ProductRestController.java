package com.alfsoftwares.honey.product;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ProductRestController {

    @GetMapping(path = "/api/products")
    public String getProducts(@AuthenticationPrincipal Jwt jwt) {

        return "Welcome on products page for " + jwt.getClaimAsString(JwtClaimNames.SUB) + " " + jwt.getClaimAsString("role");
    }
}
