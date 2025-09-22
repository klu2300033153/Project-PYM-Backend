package klu;

import jakarta.persistence.*;

@Entity
@Table(name = "MoodDetails")
public class MoodDetails {

    @Id
    private int moodId;

    @Column(nullable = false, length = 50)
    private String moodName;

    // Getters and Setters
    public int getMoodId() {
        return moodId;
    }

    public void setMoodId(int moodId) {
        this.moodId = moodId;
    }

    public String getMoodName() {
        return moodName;
    }

    public void setMoodName(String moodName) {
        this.moodName = moodName;
    }

    @Override
    public String toString() {
        return "MoodDetails [moodId=" + moodId + ", moodName=" + moodName + "]";
    }
}
