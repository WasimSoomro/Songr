package com.songrLab.songr.Repositories;
import com.songrLab.songr.Models.Album;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlbumRepo extends JpaRepository<Album, Long> {

    public Album findByTitle(String title);

}
