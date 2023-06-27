package br.com.escuderodev.catalogo.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ProductRegistrationData(
        @NotBlank(message = "o nome é obrigatório")
        String productName,
        @NotNull(message = "o valor é obrigatório")
        BigDecimal valor,
        String imageUrl) {
}
