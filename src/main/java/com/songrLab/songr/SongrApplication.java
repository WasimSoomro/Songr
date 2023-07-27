package com.songrLab.songr;

import org.springframework.boot.SpringApplication;
import org.springframework.ui.Model;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.songrLab.songr.Album;

@SpringBootApplication
public class SongrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongrApplication.class, args);
	}

	@Controller
	public class HelloController {

		@PostMapping("/album")
		public String addAlbum(@RequestParam String title, @RequestParam String artist, @RequestParam int songCount, @RequestParam int length, @RequestParam String imageUrl, Model model) {
			// Create a new album and add it to the database

			// for now, you can simply add it to your model
			Album newAlbum = new Album(title, artist, songCount, length, imageUrl);
			// you may need to adjust this line based on how you are storing albums
			model.addAttribute("album", newAlbum);

			// you could redirect to the album page to show the newly created album
			return "redirect:/album";
		}

		@GetMapping("/")
		public String getSplashPage() {
			return "splash.html";
		}

		@ResponseBody
		@GetMapping("/hello")
		public String getHelloWorld() {
			return "Hello World";
		}

		@ResponseBody
		@GetMapping("/capitalize/{input}")
		public String getCapitalize(@PathVariable("input") String input, Model model) {
			String capitalizedInput = input.toUpperCase();
			model.addAttribute("capitalizedInput", capitalizedInput);
			return "capitalize";
		}


//		@GetMapping("/album")
//		public String getAlbumPage(Model m) {
//
//			Album[] album = new Album[] {
//					new Album("Title1", "Artist1", 1, 10, "ImageUrl1"),
//					new Album("Title2", "Artist2", 2, 20, "ImageUrl2"),
//					new Album("Title3", "Artist3", 3, 30, "ImageUrl3")
//			};
//			m.addAttribute("albums", album);
//
//			return "album";
//		}

		@GetMapping("/album")
		public String getAlbumPage(Model m) {
			m.addAttribute("title", "AlbumTitle");
			m.addAttribute("artist", "AlbumArtist");
			m.addAttribute("songCount", "AlbumSongs");
			m.addAttribute("length", "AlbumLength");
//			m.addAttribute("imageURL", "AlbumImage");
			return "album.html";
		}
	}
}

