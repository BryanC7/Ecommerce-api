package cl.praxis.ecommerce.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AuthCreateUserRequest(@NotBlank String name,
                                    @NotBlank String lastName,
                                    @NotBlank String email,
                                    @NotBlank String password,
                                    @NotNull int phone,
                                    @NotNull LocalDate registerDate) {
}
