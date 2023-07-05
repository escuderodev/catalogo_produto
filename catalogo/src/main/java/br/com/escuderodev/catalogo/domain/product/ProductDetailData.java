package br.com.escuderodev.catalogo.domain.product;

import java.math.BigDecimal;

public record ProductDetailData(Long id, String productName, BigDecimal valor, String imageUrl) {
    public ProductDetailData(Product product) {
        this(product.getId(), product.getProductName(), product.getValor(), product.getImageUrl());
    }
}
