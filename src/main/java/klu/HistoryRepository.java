package klu;

//import klu.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    
    // Get all history records for a specific user
    List<History> findByUserId(Long userId);

    // Get all history records for a specific music track
    List<History> findByMusicId(Long musicId);
}
