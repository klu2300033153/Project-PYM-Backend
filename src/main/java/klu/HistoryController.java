package klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/history")
@CrossOrigin(origins = "*") // Optional: allow frontend access from different origins
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    // Create or update a history record
    @PostMapping
    public History addHistory(@RequestBody History history) {
        return historyService.saveHistory(history);
    }

    // Get all history records
    @GetMapping
    public List<History> getAllHistory() {
        return historyService.getAllHistory();
    }

    // Get history by user ID
    @GetMapping("/user/{userId}")
    public List<History> getHistoryByUserId(@PathVariable Long userId) {
        return historyService.getHistoryByUserId(userId);
    }

    // Get history by music ID
    @GetMapping("/music/{musicId}")
    public List<History> getHistoryByMusicId(@PathVariable Long musicId) {
        return historyService.getHistoryByMusicId(musicId);
    }

    // Get specific history record by ID
    @GetMapping("/{id}")
    public Optional<History> getHistoryById(@PathVariable Long id) {
        return historyService.getHistoryById(id);
    }

    // Delete a history record by ID
    @DeleteMapping("/{id}")
    public void deleteHistory(@PathVariable Long id) {
        historyService.deleteHistoryById(id);
    }
}
