package klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistMusicService {

    @Autowired
    private PlaylistMusicRepository repository;

    public List<PlaylistMusic> getAllMappings() {
        return repository.findAll();
    }

    public PlaylistMusic addMapping(PlaylistMusic mapping) {
        return repository.save(mapping);
    }

    public void deleteMapping(int playlistId, int musicId) {
        PlaylistMusicId id = new PlaylistMusicId(playlistId, musicId);
        repository.deleteById(id);
    }
}
