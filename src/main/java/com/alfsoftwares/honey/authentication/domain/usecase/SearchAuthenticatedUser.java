package com.alfsoftwares.honey.authentication.domain.usecase;

import com.alfsoftwares.honey.authentication.domain.gateway.AuthenticatedUserGateway;
import com.alfsoftwares.honey.authentication.domain.model.AuthenticatedUser;
import jakarta.inject.Inject;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchAuthenticatedUser implements UserDetailsService {
    private AuthenticatedUserGateway authenticatedUserGateway;

    @Inject
    public SearchAuthenticatedUser(final AuthenticatedUserGateway authenticatedUserGateway) {
        this.authenticatedUserGateway = authenticatedUserGateway;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthenticatedUser user = authenticatedUserGateway.findByUsername(username);

        return new User(user.username(), user.password(), getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(AuthenticatedUser user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        Map<String, Object> attributes = new HashMap<>();
        
        attributes.put("role", user.role());
        attributes.put("username", user.username());
        authorities.add(new OAuth2UserAuthority(attributes));

        return authorities;
    }
}
