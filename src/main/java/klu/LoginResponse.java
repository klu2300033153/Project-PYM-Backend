package klu;

public class LoginResponse {
    private String message;
    private int userId;

    // Constructor
    public LoginResponse(String message, int userId) {
        this.message = message;
        this.userId = userId;
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public int getUserId() {
        return userId;
    }
}
