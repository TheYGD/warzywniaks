package pio.io.warzywniaks.model.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public record CreateAdvertisementDTO(String name, String description, Object image, LocalDate startDate, LocalDate endDate) { }
