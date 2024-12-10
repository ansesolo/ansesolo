package com.alfsoftwares.honey.authentication.domain.usecase;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class CreateToken {

    private JwtEncoder jwtEncoder;

    public CreateToken(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public String generate(Authentication authentication) {
        Instant now = Instant.now();
        Optional<OAuth2UserAuthority> oAuth2UserAuthority = (Optional<OAuth2UserAuthority>) authentication.getAuthorities().stream().findFirst();
        String role = "unknown";
        if (oAuth2UserAuthority.isPresent()) {
            role = (String) oAuth2UserAuthority.get().getAttributes().get("role");
        }

        JwtClaimsSet claims = JwtClaimsSet.builder().issuer("self").issuedAt(now).expiresAt(now.plus(1, ChronoUnit.DAYS)).subject(authentication.getName()).claim("role", role).build();

        JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(JwsHeader.with(SignatureAlgorithm.RS256).build(), claims);
        return this.jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
    }
}
