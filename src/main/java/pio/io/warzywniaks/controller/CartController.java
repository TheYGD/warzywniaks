package pio.io.warzywniaks.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pio.io.warzywniaks.model.comparator.ProductInCartComparator;
import pio.io.warzywniaks.model.entity.ProductInCart;
import pio.io.warzywniaks.service.CartService;
import pio.io.warzywniaks.service.ProductInCartService;
import pio.io.warzywniaks.service.SpecialOfferService;

import java.util.List;

@Controller
public class CartController {
    CartService cartService;
    ProductInCartService productInCartService;
    SpecialOfferService specialOfferService;

    public CartController(CartService cartService, ProductInCartService productInCartService, SpecialOfferService specialOfferService) {
        this.cartService = cartService;
        this.productInCartService = productInCartService;
        this.specialOfferService = specialOfferService;
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        List<ProductInCart> products = cartService.getCart().getProducts();
        ProductInCartComparator comparator = new ProductInCartComparator();
        products.sort(comparator);
        model.addAttribute("productsInCart", products);
        model.addAttribute("specialOfferService", specialOfferService);
        model.addAttribute("totalDiscount", specialOfferService.calculateTotalDiscountInCart(products));
        model.addAttribute("totalPrice", specialOfferService.calculateTotalPriceInCart(products));
        model.addAttribute("finalPrice", specialOfferService.calculateFinalPriceInCart(products));
        return "cart/index";
    }

    @GetMapping("/cart/{productId}/sub")
    public  String substractQuantity(@PathVariable Long productId){
        productInCartService.subtractQuantity(productId);
        return "redirect:/cart";

    }

    @GetMapping("/cart/{productId}/add")
    public  String addQuantity(@PathVariable Long productId){
        productInCartService.addQuantity(productId);
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove")
    public String removeFromCart(@RequestParam Long id){
        productInCartService.removeProduct(id);
        return "redirect:/cart";
    }

}
