package com.songrLab.songr;

import com.songrLab.songr.models.Album;
import com.songrLab.songr.models.Song;
import com.songrLab.songr.repositories.AlbumRepository;
import com.songrLab.songr.repositories.SongRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

<<<<<<< HEAD
=======

import java.util.List;
import java.util.Locale;
>>>>>>> 52cbf0e1a595d3db2d08c45604a8a6b833edcb0f
@SpringBootApplication
public class SongrApplication {
	public static void main(String[] args) {
		SpringApplication.run(SongrApplication.class, args);
	}

	@Controller
	public class HelloController {

		@Autowired
		private SongRepository songRepository;
		@Autowired
		private AlbumRepository albumRepository;


		@PostMapping("/album")
		public String addAlbum(@RequestParam String title, @RequestParam String artist, @RequestParam int songCount, @RequestParam int length, @RequestParam String imageUrl, Model model) {

			Album newAlbum = new Album(title, artist, songCount, length, imageUrl);
			model.addAttribute("album", newAlbum);

			return "redirect:/album";
		}

		@PostMapping("/album/{id}/song")
		public String addSongToAlbum(@PathVariable Long id, @RequestParam String title, @RequestParam int length, @RequestParam int trackNumber) {
			Album album = albumRepository.findById(id).orElse(null);
			if (album != null) {
				Song song = new Song(title, length, trackNumber, album);
				songRepository.save(song);
			}
			return "redirect:/album/" + id;
		}
		
	

		@GetMapping("/")
		public String getSplashPage() {
			return "splash.html";
		}

		@GetMapping("/hello")
		public String getHelloWorld() {
			return "Hello World";
		}

		@GetMapping("/capitalize/{input}")
		public String getCapitalize(Model model, @PathVariable String input) {
			model.addAttribute("inTheHTML", input.toUpperCase(Locale.ROOT));
			return "capitalize";
		}

		@GetMapping("/album/{id}")
		public String getAlbumPage(@PathVariable Long id, Model model) {
			Album album = albumRepository.findById(id).orElse(null);
			if (album != null) {
				model.addAttribute("album", album);
			}
			return "album.html";
		}

		@GetMapping("/songs")
		public String getAllSongs(Model model) {
			model.addAttribute("songs", songRepository.findAll());
			return "songs";
		}


//		@GetMapping("/album")
//		public String getAlbums(Model model) {
//			Album[] album = new Album[] {
//					new Album("Title1", "Artist1", 10, 300, "ImageUrl1"),
//					new Album("Title2", "Artist2", 20, 600, "ImageUrl2"),
//					new Album("Title3", "Artist3", 30, 900, "ImageUrl3")
//			};
//			model.addAttribute("album", album);
//			return "album"
			@GetMapping("/album")
			public String getAlbums(Model model) {
				List<Album> albums = albumRepo.findAll();
				model.addAttribute("albums", albums);
				return "album";
			}
		@PostMapping("/album")
		public String addAlbum(@RequestParam String title, @RequestParam String artist, @RequestParam int songCount, @RequestParam int length, @RequestParam String imageUrl, Model model) {
			Album newAlbum = new Album(title, artist, songCount, length, imageUrl);
			albumRepo.save(newAlbum);
			return "redirect:/album";
		}
	}
}

//TA Help
