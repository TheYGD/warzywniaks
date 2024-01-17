package pio.io.warzywniaks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pio.io.warzywniaks.model.entity.AvailableProduct;
import pio.io.warzywniaks.model.entity.Category;
import pio.io.warzywniaks.service.AvailableProductService;
import pio.io.warzywniaks.service.CategoryService;
import pio.io.warzywniaks.service.SpecialOfferService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CatalogController {

    private final AvailableProductService availableProductService;
    private final CategoryService categoryService;
    private final SpecialOfferService specialOfferService;

    public CatalogController(AvailableProductService availableProductService, CategoryService categoryService, SpecialOfferService specialOfferService) {
        this.availableProductService = availableProductService;
        this.categoryService = categoryService;
        this.specialOfferService = specialOfferService;
    }

    @GetMapping({"", "/", "/index"})
    public String home(Model model) {
        List<AvailableProduct> availableProducts = availableProductService.getAllAvailableProducts();

        model.addAttribute("availableProducts", availableProducts);
        model.addAttribute("categories", categoryService.getCategoryList());
        model.addAttribute("specialOfferService", specialOfferService);
        return "index";
    }

    @GetMapping("/catalog")
    public String getCatalog(){
        return "redirect:/index";
    }

    @GetMapping("/filter")
    public String filterProducts(@RequestParam(name = "categoryIds", required = false) List<Long> categoryIds, Model model) {
        List<AvailableProduct> filteredProducts = new ArrayList<>();


        if (categoryIds != null && !categoryIds.isEmpty()) {
            List<AvailableProduct> filtered;
            for(Long id : categoryIds){
                filtered = availableProductService.getAvailableProductsByCategory(id);
                filteredProducts.addAll(filtered);
            }
        } else {
            filteredProducts = availableProductService.getAllAvailableProducts();
        }

        model.addAttribute("categories", categoryService.getCategoryList());
        model.addAttribute("availableProducts", filteredProducts);
        model.addAttribute("specialOfferService", specialOfferService);

        return "index";
    }
}

