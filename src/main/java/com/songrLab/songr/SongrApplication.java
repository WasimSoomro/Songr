package com.songrLab.songr;

import com.songrLab.songr.Models.Album;
import org.springframework.boot.SpringApplication;
import org.springframework.ui.Model;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@SpringBootApplication
public class SongrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongrApplication.class, args);
	}

	@Controller
	public class HelloController {
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
		public String getAlbums(Model model) {
			Album[] album = new Album[] {
					new Album("Title1", "Artist1", 10, 300, "ImageUrl1"),
					new Album("Title2", "Artist2", 20, 600, "ImageUrl2"),
					new Album("Title3", "Artist3", 30, 900, "ImageUrl3")
			};
			model.addAttribute("album", album);
			return "album";  // the name of your Thymeleaf template
		}
	}
}


//TA Help
