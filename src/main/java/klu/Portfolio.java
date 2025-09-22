package klu;

import jakarta.persistence.*;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId; // Matches Authentication table's userId

    @Column
    private String firstname;
    @Column
    private String middlename;
    @Column
    private String lastname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String phonenumber;
    @Column
    private String dateOfBirth;
    @Column
    private String photo;
    @Column
    private String address;

    // Adding password field directly to Portfolio
    @Column(nullable = false)
    private String password;  // This password field will be used directly for registration

    @OneToOne(cascade = CascadeType.ALL)  // Cascade the Authentication entity when saving Portfolio
    @JoinColumn(name = "userId", referencedColumnName = "userId")  // Make sure the column references the correct key in Authentication table
    private Authentication authentication;

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    @Override
    public String toString() {
        return "Portfolio [userId=" + userId + ", firstname=" + firstname + ", middlename=" + middlename + 
               ", lastname=" + lastname + ", email=" + email + ", phonenumber=" + phonenumber + 
               ", dateOfBirth=" + dateOfBirth + ", photo=" + photo + ", address=" + address + ", password=" + password + "]";
    }
}
