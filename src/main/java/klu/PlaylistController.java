package klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
@CrossOrigin(origins = "*") // Allow frontend access (you can restrict this)
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    // GET all Playlists
    @GetMapping("/all")
    public List<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    // GET Playlist by ID
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable int id) {
        return playlistService.getPlaylistById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/image/{name}")
    public ResponseEntity<byte[]> retrieveMusicImage(@PathVariable("name") String name) {
        byte[] imageData = playlistService.retrieveImageData(name);

        MediaType mediaType = MediaType.IMAGE_JPEG;

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + name + "")
                .contentType(mediaType)
                .body(imageData);
    }

    // POST new Playlist
    @PostMapping
    public Playlist addPlaylist(@RequestBody Playlist playlist) {
        return playlistService.addPlaylist(playlist);
    }

    // PUT update Playlist
    @PutMapping("/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable int id, @RequestBody Playlist updatedPlaylist) {
        Playlist updated = playlistService.updatePlaylist(id, updatedPlaylist);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // DELETE Playlist
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable int id) {
        return playlistService.deletePlaylist(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
