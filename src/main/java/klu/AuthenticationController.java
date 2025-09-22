package klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

//    // User Login Endpoint
//    @PostMapping("/login")
//    public String loginUser(@RequestBody Authentication auth) {
//        return authenticationService.loginUser(auth);
//    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody Authentication auth) {
        return authenticationService.loginUser(auth);
    }

    
    
    // Check if an email exists (still useful)
    @GetMapping("/exists")
    public boolean doesEmailExist(@RequestParam String email) {
        return authenticationService.checkEmailExists(email);
    }
}
