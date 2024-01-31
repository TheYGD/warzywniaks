//package pio.io.warzywniaks.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import pio.io.warzywniaks.model.dto.CreateAdvertisementDTO;
//import pio.io.warzywniaks.model.dto.advertisement.AdvertisementDTO;
//import pio.io.warzywniaks.model.dto.advertisement.AdvertisementListDTO;
//import pio.io.warzywniaks.service.AdvertisementService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/advertisements")
//@RequiredArgsConstructor
//class AdvertisementApiController {
//    private final AdvertisementService advertisementService;
//
//    @GetMapping
//    public ResponseEntity<AdvertisementListDTO> getAdvertisements() {
//        List<AdvertisementDTO> advertisements = advertisementService.getAdvertisements();
//        AdvertisementListDTO advertisementListDTO = new AdvertisementListDTO(advertisements);
//        return ResponseEntity.status(HttpStatus.OK).body(advertisementListDTO);
//    }
//
//    @PostMapping
//    public ResponseEntity<AdvertisementDTO> createAdvertisement(@RequestBody CreateAdvertisementDTO createAdvertisementDTO) {
//        AdvertisementDTO createdAdvertisement = advertisementService.createAdvertisement(createAdvertisementDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdvertisement);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<AdvertisementDTO> updateAdvertisement(@PathVariable Long id,
//                                                                @RequestBody CreateAdvertisementDTO createAdvertisementDTO) {
//        AdvertisementDTO updatedAdvertisement = advertisementService.updateAdvertisement(id, createAdvertisementDTO);
//        return ResponseEntity.status(HttpStatus.OK).body(updatedAdvertisement);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteAdvertisement(@PathVariable Long id) {
//        advertisementService.deleteAdvertisement(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<AdvertisementDTO> getAdvertisement(@PathVariable Long id) {
//        AdvertisementDTO advertisement = advertisementService.getAdvertisement(id);
//        return ResponseEntity.status(HttpStatus.OK).body(advertisement);
//    }
//}
