package com.songrLab.songr.repositories;
import com.songrLab.songr.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SongRepository extends JpaRepository<Song, Long> {
}
