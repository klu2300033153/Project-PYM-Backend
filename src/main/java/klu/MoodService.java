package klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoodService {

    @Autowired
    private MoodRepository moodRepository;

    public List<MoodDetails> getAllMoods() {
        return moodRepository.findAll();
    }

    public Optional<MoodDetails> getMoodById(int id) {
        return moodRepository.findById(id);
    }

    public MoodDetails addMood(MoodDetails mood) {
        return moodRepository.save(mood);
    }

    public void deleteMood(int id) {
        moodRepository.deleteById(id);
    }

    public MoodDetails updateMood(MoodDetails mood) {
        return moodRepository.save(mood); // save works as update if id exists
    }
}
