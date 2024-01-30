package pio.io.warzywniaks.model.dto.advertisement;

import pio.io.warzywniaks.model.dto.product.ProductDTO;

import java.util.List;

public record AdvertisementDTO(Long id, String name, String description, String imageUrl, List<ProductDTO> productIds) {}
