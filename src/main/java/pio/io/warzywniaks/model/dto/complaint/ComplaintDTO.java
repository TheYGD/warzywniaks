package pio.io.warzywniaks.model.dto.complaint;

import java.time.LocalDate;

public record ComplaintDTO(long id, String description, LocalDate date, String user, long order_id){}
