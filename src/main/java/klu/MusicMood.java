package klu;

import jakarta.persistence.*;

@Entity
@Table(name = "MusicMood")
public class MusicMood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int musicMoodId;

    @ManyToOne
    @JoinColumn(name = "musicId", referencedColumnName = "musicId", nullable = false)
    private Music music;

    @ManyToOne
    @JoinColumn(name = "moodId", referencedColumnName = "moodId", nullable = false)
    private MoodDetails mood;

    // Getters and Setters
    public int getMusicMoodId() {
        return musicMoodId;
    }

    public void setMusicMoodId(int musicMoodId) {
        this.musicMoodId = musicMoodId;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public MoodDetails getMood() {
        return mood;
    }

    public void setMood(MoodDetails mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return "MusicMood [musicMoodId=" + musicMoodId + ", music=" + music.getSongName() + ", mood=" + mood.getMoodName() + "]";
    }
}
