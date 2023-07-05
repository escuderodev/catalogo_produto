package br.com.escuderodev.catalogo.domain.product;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity(name = "Product")
@Table(name = "product")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private BigDecimal valor;
    private String imageUrl;
    @CreationTimestamp
    private Timestamp createDate;
    @UpdateTimestamp
    private Timestamp updateDate;

    public Product(ProductRegistrationData data) {
        this.productName = data.productName();
        this.valor = data.valor();
        this.imageUrl = data.imageUrl();
    }

    public void productUpdate(ProductUpdateData data) {
        if (data.productName() != null) {
            this.productName = data.productName();
        }
        if (data.productName() != null) {
            this.valor = data.valor();
        }
        if (data.productName() != null) {
            this.imageUrl = data.imageUrl();
        }
    }
}
