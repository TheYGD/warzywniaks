package pio.io.warzywniaks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pio.io.warzywniaks.model.repository.ComplaintRepository;

@Service
@RequiredArgsConstructor
public class ComplaintService {
    private final ComplaintRepository complaintRepository;

}
