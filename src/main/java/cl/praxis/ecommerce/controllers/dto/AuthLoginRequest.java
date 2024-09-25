package cl.praxis.ecommerce.controllers.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(@NotBlank String email,
                               @NotBlank String password) {
}