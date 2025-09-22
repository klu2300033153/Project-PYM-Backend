package klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlistmusic")
@CrossOrigin(origins = "*")
public class PlaylistMusicController {

    @Autowired
    private PlaylistMusicService service;

    @GetMapping("/all")
    public List<PlaylistMusic> getAllMappings() {
        return service.getAllMappings();
    }

    @PostMapping
    public PlaylistMusic addMapping(@RequestBody PlaylistMusic mapping) {
        return service.addMapping(mapping);
    }

    @DeleteMapping("/{playlistId}/{musicId}")
    public void deleteMapping(@PathVariable int playlistId, @PathVariable int musicId) {
        service.deleteMapping(playlistId, musicId);
    }
}
