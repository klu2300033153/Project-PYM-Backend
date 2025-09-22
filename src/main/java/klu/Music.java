package klu;

import jakarta.persistence.*;

@Entity
@Table(name = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int musicId;

    @Column(nullable = false, length = 100)
    private String songName;

    @Column(length = 255)
    private String coverImageUrl;

    @Column(nullable = false, length = 255)
    private String songAddress;

    @Column(nullable = false)
    private boolean isVisible = true; // ✅ Fixed declaration

    // Getters & Setters
    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getSongAddress() {
        return songAddress;
    }

    public void setSongAddress(String songAddress) {
        this.songAddress = songAddress;
    }

    public boolean getIsVisible() {
    	System.out.println("Is Visbile: " + isVisible);
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    @Override
    public String toString() {
        return "Music [musicId=" + musicId + ", songName=" + songName + ", coverImageUrl=" + coverImageUrl
                + ", songAddress=" + songAddress + ", isVisible=" + isVisible + "]";
    }
}
