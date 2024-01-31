package pio.io.warzywniaks.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pio.io.warzywniaks.model.dto.Report;
import pio.io.warzywniaks.model.entity.Product;
import pio.io.warzywniaks.model.entity.User;
import pio.io.warzywniaks.model.repository.ProductRepository;
import pio.io.warzywniaks.model.repository.UserRepository;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Getter
    List<Report> reports = new LinkedList<>() {
        {
            add(new Report(1L, "Produkty w sklepie"));
            add(new Report(2L, "Użytkownicy"));
            add(new Report(3L, "Rozliczenie na ten miesiąc"));
        }
    };

    public String generateReport(Long id) {
        switch (id.intValue()) {
            case 1:
                List<Product> products = productRepository.findAll();
                return "<h4 class='mb-5'>Produkty (" + products.size() + ")</h3>" + products.stream().reduce("", (acc, user) -> acc + "<p>" + user.getName() + " " + user.getPrice() + "</p>", String::concat);
            case 2:
                List<User> users = userRepository.findAll();
                return "<h4 class='mb-5'>Użytkownicy (" + users.size() + ")</h3>" + users.stream().reduce("", (acc, user) -> acc + "<p>" + user.getFirstName() + " " + user.getLastName() + "</p>", String::concat);
            case 3:
                return """
                        <h4>Rozliczenie na ten miesiąc</h3>
                        <p class='mt-5'>Przychód: 1000.00 zł</p>
                        <p>Koszty: 500.00 zł</p>
                        <p>Zysk: 500.00 zł</p>
                        """;
            default:
                return "Nie ma takiego raportu!";
        }
    }
}
