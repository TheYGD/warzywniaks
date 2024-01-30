package pio.io.warzywniaks.model.dto;

import lombok.Data;

import java.util.List;

public record CreateAdvertisementDTO(String name, String description, String imageUrl, List<Long> productIds) { }
