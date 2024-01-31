package pio.io.warzywniaks.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pio.io.warzywniaks.model.dto.CreateAdvertisementDTO;
import pio.io.warzywniaks.model.dto.advertisement.AdvertisementDTO;
import pio.io.warzywniaks.model.dto.advertisement.AdvertisementListDTO;
import pio.io.warzywniaks.model.entity.Advertisement;
import pio.io.warzywniaks.service.AdvertisementService;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/advertisements")
@RequiredArgsConstructor
class AdvertisementController {
    private final AdvertisementService advertisementService;

    @GetMapping
    public String  getAdvertisements(Model model) {
        List<AdvertisementDTO> advertisements = advertisementService.getAdvertisements();
        advertisements.sort(Comparator.comparing(AdvertisementDTO::name));
        AdvertisementListDTO advertisementListDTO = new AdvertisementListDTO(advertisements);
        model.addAttribute("advertisements", advertisementListDTO.advertisements());
        return "advertisement/list";
    }

    @GetMapping("/{id}")
    public String getAdvertisement(@PathVariable Long id, Model model) {
        AdvertisementDTO advertisement = advertisementService.getAdvertisement(id);
        model.addAttribute("advertisement", advertisement);
        return "advertisement/details";
    }

    @GetMapping("/create")
    public String createAdvertisementForm(Model model) {
        model.addAttribute("advertisement", new Advertisement());
        return "advertisement/create";
    }

    @PostMapping
    public String createAdvertisement(@ModelAttribute CreateAdvertisementDTO createAdvertisementDTO) {
        AdvertisementDTO createdAdvertisement = advertisementService.createAdvertisement(createAdvertisementDTO);
        return "redirect:/advertisements/" + createdAdvertisement.id();
    }

    @GetMapping("/{id}/update")
    public String updateAdvertisementForm(@PathVariable Long id, Model model) {
        AdvertisementDTO advertisement = advertisementService.getAdvertisement(id);
        model.addAttribute("advertisement", advertisement);
        return "advertisement/update";
    }

    @PostMapping("/{id}/update")
    public String updateAdvertisement(@PathVariable Long id,
                                      @ModelAttribute CreateAdvertisementDTO createAdvertisementDTO) {
        AdvertisementDTO updatedAdvertisement = advertisementService.updateAdvertisement(id, createAdvertisementDTO);
        return "redirect:/advertisements/" + updatedAdvertisement.id();
    }

    @GetMapping("/{id}/delete")
    public String deleteAdvertisement(@PathVariable Long id) {
        advertisementService.deleteAdvertisement(id);
        return "redirect:/advertisements";
    }
}
