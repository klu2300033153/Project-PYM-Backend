package klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    // Save a new history record
    public History saveHistory(History history) {
        return historyRepository.save(history);
    }

    // Get all history records
    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

    // Get history by user ID
    public List<History> getHistoryByUserId(Long userId) {
        return historyRepository.findByUserId(userId);
    }

    // Get history by music ID
    public List<History> getHistoryByMusicId(Long musicId) {
        return historyRepository.findByMusicId(musicId);
    }

    // Get a history record by its ID
    public Optional<History> getHistoryById(Long id) {
        return historyRepository.findById(id);
    }

    // Delete a history record by ID
    public void deleteHistoryById(Long id) {
        historyRepository.deleteById(id);
    }
}
