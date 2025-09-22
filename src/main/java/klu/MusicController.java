package klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music")
@CrossOrigin(origins = "*") // Allow frontend access (you can restrict this)
public class MusicController {

    @Autowired
    private MusicService musicService;

    // GET all songs
    @GetMapping("/all")
    public List<Music> getAllMusic() {
        return musicService.getAllMusic();
    }


    @GetMapping("/{id}")
    public ResponseEntity<byte[]> retrieveMusicFile(@PathVariable("id") Integer id) {
        byte[] musicData = musicService.retrieveMusicData(id);

        MediaType mediaType = MediaType.parseMediaType("audio/mpeg");

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + id + "\"")
                .contentType(mediaType)
                .body(musicData);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> retrieveMusicImage(@PathVariable("id") Integer id) {
        byte[] imageData = musicService.retrieveImageData(id);

        MediaType mediaType = MediaType.IMAGE_JPEG;

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + id + ".jpg\"")
                .contentType(mediaType)
                .body(imageData);
    }

    private MediaType getImageMediaType(String imageName) {
        if (imageName.toLowerCase().endsWith(".png")) {
            return MediaType.IMAGE_PNG;
        } else if (imageName.toLowerCase().endsWith(".jpg") || imageName.toLowerCase().endsWith(".jpeg")) {
            return MediaType.IMAGE_JPEG;
        } else if (imageName.toLowerCase().endsWith(".gif")) {
            return MediaType.IMAGE_GIF;
        } else {
            return MediaType.APPLICATION_OCTET_STREAM; // default fallback
        }
    }	

    
    // POST new song
    @PostMapping
    public Music addMusic(@RequestBody Music music) {
        return musicService.addMusic(music);
    }

    // PUT update song
    @PutMapping("/{id}")
    public ResponseEntity<Music> updateMusic(@PathVariable int id, @RequestBody Music updatedMusic) {
        Music updated = musicService.updateMusic(id, updatedMusic);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // DELETE song
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusic(@PathVariable int id) {
        return musicService.deleteMusic(id) ? 
            ResponseEntity.noContent().build() : 
            ResponseEntity.notFound().build();
    }
}
