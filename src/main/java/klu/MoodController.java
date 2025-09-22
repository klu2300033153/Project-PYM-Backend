package klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/moods")
public class MoodController {

    @Autowired
    private MoodService moodService;

    @GetMapping
    public List<MoodDetails> getAllMoods() {
        return moodService.getAllMoods();
    }

    @GetMapping("/{id}")
    public Optional<MoodDetails> getMoodById(@PathVariable int id) {
        return moodService.getMoodById(id);
    }

    @PostMapping
    public MoodDetails addMood(@RequestBody MoodDetails mood) {
        return moodService.addMood(mood);
    }

    @PutMapping
    public MoodDetails updateMood(@RequestBody MoodDetails mood) {
        return moodService.updateMood(mood);
    }

    @DeleteMapping("/{id}")
    public void deleteMood(@PathVariable int id) {
        moodService.deleteMood(id);
    }
}
