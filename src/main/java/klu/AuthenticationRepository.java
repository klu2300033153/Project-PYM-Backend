package klu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Integer> {
    // Check if an authentication record exists by email
    boolean existsByMailId(String mailId);

    // Find Authentication by mailId
    Authentication findByMailId(String mailId);
}
