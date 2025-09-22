package klu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistMusicRepository extends JpaRepository<PlaylistMusic, PlaylistMusicId> {
}
