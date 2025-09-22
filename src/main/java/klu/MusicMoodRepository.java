package klu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicMoodRepository extends JpaRepository<MusicMood, Integer> {
    // Custom query methods (if any) can be added here
}
