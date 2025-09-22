package klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

//    // User Login Service
//    public String loginUser(Authentication auth) {
//        // Check if the email exists
//        if (!authenticationRepository.existsByMailId(auth.getMailId())) {
//            return "Email not found";
//        }
//
//        // Retrieve the stored authentication object
//        Authentication storedAuth = authenticationRepository.findByMailId(auth.getMailId());
//
//        // Directly compare the passwords (plain text)
//        if (storedAuth.getPassword().equals(auth.getPassword())) {
//            return "Login successful";
//        } else {
//            return "Invalid password";
//        }
//    }

    public LoginResponse loginUser(Authentication auth) {
        if (!authenticationRepository.existsByMailId(auth.getMailId())) {
            return new LoginResponse("Email not found", -1);
        }

        Authentication storedAuth = authenticationRepository.findByMailId(auth.getMailId());

        if (storedAuth.getPassword().equals(auth.getPassword())) {
            return new LoginResponse("Login successful", storedAuth.getUserId());
        } else {
            return new LoginResponse("Invalid password", -1);
        }
    }

    
    
    // Check if an email exists
    public boolean checkEmailExists(String email) {
        return authenticationRepository.existsByMailId(email);
    }
}
