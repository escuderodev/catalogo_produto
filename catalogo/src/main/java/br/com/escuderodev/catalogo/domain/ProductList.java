package br.com.escuderodev.catalogo.domain;

import java.math.BigDecimal;

public record ProductList(Long id, String productName, BigDecimal valor, String imageUrl) {
    public ProductList(Product product) {
        this(product.getId(), product.getProductName(), product.getValor(), product.getImageUrl());
    }
}
