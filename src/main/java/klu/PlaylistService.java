package klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    // Get all Playlists
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    // Get Playlist by ID
    public Optional<Playlist> getPlaylistById(int id) {
        return playlistRepository.findById(id);
    }

    // Add a new Playlist
    public Playlist addPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    // Update an existing Playlist
    public Playlist updatePlaylist(int id, Playlist updatedPlaylist) {
        return playlistRepository.findById(id)
                .map(playlist -> {
                    playlist.setName(updatedPlaylist.getName());
                    playlist.setCreated(updatedPlaylist.getCreated());
                    playlist.setUpdated(updatedPlaylist.getUpdated());
                    playlist.setPublic(updatedPlaylist.isPublic());
                    playlist.setNumberOfTracks(updatedPlaylist.getNumberOfTracks());
                    playlist.setCoverImageUrl(updatedPlaylist.getCoverImageUrl());
                    return playlistRepository.save(playlist);
                }).orElse(null);
    }
    
    public byte[] retrieveImageData(String imageName) {
        try {
            ClassPathResource resource = new ClassPathResource("static/" + imageName);

            if (resource.exists()) {
                return resource.getInputStream().readAllBytes();
            } else {
                throw new RuntimeException("Could not read the image file: " + imageName);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading image data: ", e);
        }
    }


    // Delete Playlist by ID
    public boolean deletePlaylist(int id) {
        if (playlistRepository.existsById(id)) {
            playlistRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
