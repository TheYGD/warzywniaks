package pio.io.warzywniaks.model.dto.advertisement;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import pio.io.warzywniaks.model.dto.product.ProductDTO;

import java.time.LocalDate;
import java.util.List;

public record AdvertisementDTO(Long id, String name, String description, String image,
                               @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                               @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
}
