package com.alfsoftwares.honey.administration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministrationRestController {

    @GetMapping("/admin")
    public String getAdmin(@AuthenticationPrincipal Jwt jwt) {
        return "Welcome on administration page " + jwt.getClaimAsString(JwtClaimNames.SUB) + " " + jwt.getClaimAsString("role");
    }
}
