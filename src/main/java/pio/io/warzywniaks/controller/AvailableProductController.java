package pio.io.warzywniaks.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pio.io.warzywniaks.model.entity.AvailableProduct;
import pio.io.warzywniaks.service.AvailableProductService;
import pio.io.warzywniaks.service.CartService;
import pio.io.warzywniaks.service.SpecialOfferService;

import java.util.List;

@Controller
public class AvailableProductController {
    AvailableProductService availableProductService;
    SpecialOfferService specialOfferService;
    CartService cartService;

    public AvailableProductController(AvailableProductService availableProductService, SpecialOfferService specialOfferService, CartService cartService) {
        this.availableProductService = availableProductService;
        this.specialOfferService = specialOfferService;
        this.cartService = cartService;
    }


    @GetMapping("/details/{productId}")
    public String showDetails(@PathVariable long productId, Model model) {
        model.addAttribute("availableProduct", availableProductService.getProductById(productId));
        model.addAttribute("specialOfferService", specialOfferService);
        return "/details/index";
    }

    @PostMapping("/details/add/{productId}")
    public String add(@PathVariable long productId, @RequestParam int quantity) {
        AvailableProduct availableProduct = availableProductService.getProductById(productId);
        cartService.addToCart(availableProduct, quantity);
        availableProductService.substractAmount(productId, quantity);
        return "redirect:/details/" + productId;


    }
}
