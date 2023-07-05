package br.com.escuderodev.catalogo.controller;

import br.com.escuderodev.catalogo.domain.product.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity<List<Product>> loadProductList() {
        List<Product> productList = repository.findAll();
        return ResponseEntity.ok(productList);
    }

    @PostMapping
    @Transactional
    public ResponseEntity productRegistration(@RequestBody @Valid ProductRegistrationData data, UriComponentsBuilder uriBuilder) {
        var product = new Product(data);
        repository.save(product);
        var uri = uriBuilder.path("products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductDetailData(product));
    }

    @PutMapping
    @Transactional
    public ResponseEntity productUpdate(@RequestBody @Valid ProductUpdateData data) {
        var product = repository.getReferenceById(data.id());
        product.productUpdate(data);
        return ResponseEntity.ok(new ProductDetailData(product));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity productDeleteById(@PathVariable Long id) {
        var product = repository.getReferenceById(id);
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
