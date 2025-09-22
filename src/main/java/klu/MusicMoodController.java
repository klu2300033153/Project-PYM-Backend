package klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicMood")
@CrossOrigin(origins = "*") // Allow frontend access (you can restrict this)
public class MusicMoodController {

    @Autowired
    private MusicMoodService musicMoodService;

    // GET all MusicMood relationships
    @GetMapping("/all")
    public List<MusicMood> getAllMusicMood() {
        return musicMoodService.getAllMusicMood();
    }

    // GET MusicMood by ID
    @GetMapping("/{id}")
    public ResponseEntity<MusicMood> getMusicMoodById(@PathVariable int id) {
        return musicMoodService.getMusicMoodById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST new MusicMood
    @PostMapping
    public MusicMood addMusicMood(@RequestBody MusicMood musicMood) {
        return musicMoodService.addMusicMood(musicMood);
    }

    // PUT update MusicMood
    @PutMapping("/{id}")
    public ResponseEntity<MusicMood> updateMusicMood(@PathVariable int id, @RequestBody MusicMood updatedMusicMood) {
        MusicMood updated = musicMoodService.updateMusicMood(id, updatedMusicMood);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // DELETE MusicMood
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusicMood(@PathVariable int id) {
        return musicMoodService.deleteMusicMood(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
