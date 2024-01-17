package pio.io.warzywniaks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pio.io.warzywniaks.model.entity.Category;
import pio.io.warzywniaks.model.entity.Product;
import pio.io.warzywniaks.model.repository.CategoryRepository;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }


    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void addProductToCategory(Product product, String string){
        Category category = categoryRepository.findByName(string);
        category.getProductList().add(product);
    }

    public void addCategory(Category category) {
        if (!isNameUnique(category)) {
            throw new IllegalArgumentException("A category with this name already exists");
        }
        categoryRepository.save(category);
    }

    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }

    public boolean isNameUnique(Category category) {
        for (Category cat : categoryRepository.findAll()) {
            if (cat.getName().equals(category.getName()) && cat.getId() != category.getId()) {
                return false;
            }
        }
        return true;
    }


}
