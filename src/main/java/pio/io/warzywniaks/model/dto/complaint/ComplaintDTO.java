package pio.io.warzywniaks.model.dto.complaint;

import java.time.LocalDate;

public record ComplaintDTO(Long id, String description, LocalDate date, String user, Long orderId){}
