package pio.io.warzywniaks.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pio.io.warzywniaks.model.dto.Report;
import pio.io.warzywniaks.service.ReportService;

import java.util.List;

@Controller
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping
    public String getReports(Model model) {
        List<Report> reports = reportService.getReports();
        model.addAttribute("reports", reports);
        return "report/index";
    }

    @GetMapping("/{id}")
    public String generateReport(@PathVariable Long id, Model model) {
        String payload = reportService.generateReport(id);
        model.addAttribute("payload", payload);
        return "report/report";
    }
}
