package klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicMoodService {

    @Autowired
    private MusicMoodRepository musicMoodRepository;

    // Get all MusicMood relationships
    public List<MusicMood> getAllMusicMood() {
        return musicMoodRepository.findAll();
    }

    // Get MusicMood by ID
    public Optional<MusicMood> getMusicMoodById(int id) {
        return musicMoodRepository.findById(id);
    }

    // Add a new MusicMood
    public MusicMood addMusicMood(MusicMood musicMood) {
        return musicMoodRepository.save(musicMood);
    }

    // Update existing MusicMood
    public MusicMood updateMusicMood(int id, MusicMood updatedMusicMood) {
        return musicMoodRepository.findById(id)
                .map(musicMood -> {
                    musicMood.setMusic(updatedMusicMood.getMusic());
                    musicMood.setMood(updatedMusicMood.getMood());
                    return musicMoodRepository.save(musicMood);
                }).orElse(null);
    }

    // Delete a MusicMood by ID
    public boolean deleteMusicMood(int id) {
        if (musicMoodRepository.existsById(id)) {
            musicMoodRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
