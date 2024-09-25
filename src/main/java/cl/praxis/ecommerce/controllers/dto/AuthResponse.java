package cl.praxis.ecommerce.controllers.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"email", "message", "status", "jwt"})
public record AuthResponse(
        String email,
        String message,
        String jwt,
        boolean status) {
}