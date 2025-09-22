package klu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.data.jpa.domain.JpaSort.Path;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Service;

import java.net.MalformedURLException;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;
    private final String audioDirectory = "/src/main/resource/static";

    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    public Optional<Music> getMusicById(int id) {
        return musicRepository.findById(id);
    }

    public Music addMusic(Music music) {
        return musicRepository.save(music);
    }
    
//    public byte[] retrieveMusicData(Integer id) {
//        try {
//        	Optional<Music> musicOptional = getMusicById(id); 
//
//        	String audioName = musicOptional.map(Music::getSongAddress)
//        	                               .orElse("Default Song Address");
//
//        	java.nio.file.Path audioPath = Paths.get(audioDirectory).resolve(audioName).normalize();
//            Resource resource = new UrlResource(audioPath.toUri());
//
//            if (resource.exists() && resource.isReadable()) {
//                return Files.readAllBytes(audioPath);
//            } else {
//                throw new RuntimeException("Could not read the audio file: " + audioName);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException("Error reading audio data: ", e);
//        }
//    }

    public byte[] retrieveMusicData(Integer id) {
        try {
            Optional<Music> musicOptional = getMusicById(id);

            String audioName = musicOptional.map(Music::getSongAddress)
                                            .orElse("default.mp3");

            // Load from classpath (resources/static/)
            ClassPathResource resource = new ClassPathResource("static/" + audioName);

            if (resource.exists()) {
                return resource.getInputStream().readAllBytes();
            } else {
                throw new RuntimeException("Could not read the audio file: " + audioName);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading audio data: ", e);
        }
    }
    
//    public byte[] retrieveImageData(String imageName) {
//        try {
//            Path imagePath = Paths.get(imageDirectory).resolve(imageName).normalize();
//            Resource resource = new UrlResource(imagePath.toUri());
//
//            if (resource.exists() && resource.isReadable()) {
//                return Files.readAllBytes(imagePath);
//            } else {
//                throw new RuntimeException("Could not read the image file: " + imageName);
//            }
//        } catch (MalformedURLException e) {
//            throw new RuntimeException("Invalid image path: " + imageName, e);
//        } catch (IOException e) {
//            throw new RuntimeException("Error reading image data: " + imageName, e);
//        }
//    }
    
    public byte[] retrieveImageData(Integer id) {
        try {
            Optional<Music> musicOptional = getMusicById(id);

            // Default fallback image file
            String imageName = musicOptional
                    .map(Music::getCoverImageUrl)
                    .orElse("default.jpg");

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



    
    public Music updateMusic(int id, Music updatedMusic) {
        return musicRepository.findById(id).map(music -> {
            music.setSongName(updatedMusic.getSongName());
            music.setCoverImageUrl(updatedMusic.getCoverImageUrl());
            music.setSongAddress(updatedMusic.getSongAddress());
            return musicRepository.save(music);
        }).orElse(null);
    }

    public boolean deleteMusic(int id) {
        if (musicRepository.existsById(id)) {
            musicRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
