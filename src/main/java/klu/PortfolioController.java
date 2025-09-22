package klu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolio")
@CrossOrigin("*")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    // Register Portfolio
    @PostMapping("/register")
    public String registerPortfolio(@RequestBody Portfolio portfolio) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nMail: " + portfolio.getEmail() + " | Password " + portfolio.getPassword());
        return portfolioService.registerPortfolio(portfolio);  // register the portfolio and authentication
    }

    @GetMapping("/retrieve/{id}")
    public List<Portfolio> retrieveDetails(@PathVariable("id") Integer id) {
        Portfolio p = portfolioService.getPortfolioById(id);
        System.out.println(p);
        List l = p != null ? List.of(p) : List.of();
        System.out.println(l);
        return l;
    }

    // Check if Email Exists (for Registration)
    @GetMapping("/exists")
    public boolean doesEmailExist(@RequestParam(name = "email") String email) {
        return portfolioService.checkEmailExists(email);  // check if the email already exists
    }
}
