package klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private AuthenticationRepository authenticationRepository;

    // Register a new portfolio
    public String registerPortfolio(Portfolio portfolio) {
        // Check if the email already exists
        if (portfolioRepository.existsByEmail(portfolio.getEmail())) {
            return "Error: Email already registered!";
        }

        // Save authentication details with plain password
        Authentication authentication = new Authentication();
        authentication.setMailId(portfolio.getEmail());
        authentication.setPassword(portfolio.getPassword()); // Directly set the password (plain text)
        authenticationRepository.save(authentication);

        // Set the authentication object to portfolio
        portfolio.setAuthentication(authentication);
        
        // Save the portfolio
        portfolioRepository.save(portfolio);
        return "Portfolio and Authentication registered successfully!";
    }
    
    public Portfolio getPortfolioById(Integer id) {
        return portfolioRepository.findById(id).orElse(null);
    }


    // Check if an email already exists
    public boolean checkEmailExists(String email) {
        return portfolioRepository.existsByEmail(email);
    }
}
