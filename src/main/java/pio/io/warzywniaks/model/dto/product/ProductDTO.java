package pio.io.warzywniaks.model.dto.product;

import pio.io.warzywniaks.model.dto.category.CategoryDTO;

import java.math.BigDecimal;

public record ProductDTO(Long id, String imageUrl, String name, String number, BigDecimal price, CategoryDTO category) {}
