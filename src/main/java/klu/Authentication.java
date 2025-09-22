package klu;

import jakarta.persistence.*;

@Entity
@Table(name = "authentication")
public class Authentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId; // Matches Portfolio table's userId

    @Column(unique = true, nullable = false)
    private String mailId;

    private String password;

    @OneToOne(mappedBy = "authentication")  // Reverse mapping from Portfolio entity
    private Portfolio portfolio;  // Portfolio will contain the Authentication reference

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Authentication [userId=" + userId + ", mailId=" + mailId + ", password=" + password + "]";
    }
}
