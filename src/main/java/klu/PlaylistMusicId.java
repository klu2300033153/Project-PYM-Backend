package klu;

import java.io.Serializable;
import java.util.Objects;

public class PlaylistMusicId implements Serializable {

    private int playlistId;
    private int musicId;

    public PlaylistMusicId() {}

    public PlaylistMusicId(int playlistId, int musicId) {
        this.playlistId = playlistId;
        this.musicId = musicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlaylistMusicId)) return false;
        PlaylistMusicId that = (PlaylistMusicId) o;
        return playlistId == that.playlistId && musicId == that.musicId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistId, musicId);
    }
}
