package pio.io.warzywniaks.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pio.io.warzywniaks.model.dto.complaint.ComplaintDTO;
import pio.io.warzywniaks.model.dto.complaint.ComplaintListDTO;

@RestController
@RequestMapping("/api/v1/complaints")
public class ComplaintController {

    @GetMapping("/all")
    public ResponseEntity<ComplaintListDTO> getAllComplaints(){
        return new ResponseEntity<>(null, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ComplaintDTO> getComplaintDetails(@PathVariable long id){
        return new ResponseEntity<>(null, HttpStatusCode.valueOf(200));
    }

    @PutMapping("/{id}/update")
    public void updateComplaintStatus(@PathVariable long id){

    }
}
