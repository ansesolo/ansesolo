package com.alfsoftwares.honey.authentication.domain.model;

public record AuthenticatedUser(Long id, String username, String password, String role) {
}
