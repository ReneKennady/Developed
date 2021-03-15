package lib.sys.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lib.sys.bean.Library;
import lib.sys.service.LibService;

@RestController
public class LibController {

	@Autowired
	private LibService libService;

	@PostMapping("/upload")
	public void uplaodImage(@RequestParam("imageFile") MultipartFile file, @RequestParam("bookName") String bookName,
			@RequestParam("author") String author) throws IOException {

		libService.uplaodImage(bookName, author, file);

	}

	@GetMapping(path = { "/get/book/{bookName}" })
	public Library searchByBook(@PathVariable("bookName") String bookName) throws IOException {
		return libService.searchByBook(bookName);
	}
	
	
	@GetMapping(path = { "/get/author/{author}" })
	public Library searchByAuthor(@PathVariable("author") String author) throws IOException {
		return libService.searchByAuthor(author);
	}

}
