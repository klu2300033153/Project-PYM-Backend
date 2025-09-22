package klu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodRepository extends JpaRepository<MoodDetails, Integer> {
    // You can add custom queries if needed later
}
