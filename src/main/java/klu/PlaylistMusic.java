package klu;

import jakarta.persistence.*;

@Entity
@Table(name = "PlaylistMusic")
@IdClass(PlaylistMusicId.class)
public class PlaylistMusic {

    @Id
    @Column(name = "playlistId")
    private int playlistId;

    @Id
    @Column(name = "musicId")
    private int musicId;

    // Getters and Setters

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }
}
