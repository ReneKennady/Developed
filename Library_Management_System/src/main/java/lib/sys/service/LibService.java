package lib.sys.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lib.sys.bean.Library;
import lib.sys.db.LibRepository;

@Service
public class LibService {

	@Autowired
	private LibRepository libRepository;

	public void uplaodImage(String name, String author, MultipartFile file) throws IOException {

//		System.out.println("Original file size in bytes - " + file.getBytes().length);

		Library lib = new Library(name, author,	compressBytes(file.getBytes()));

		libRepository.save(lib);



	}

	public Library searchByBook(String bookName) throws IOException {

		return libRepository.findByBookName(bookName);

	}

	public Library searchByAuthor(String author) throws IOException {

		return libRepository.findByAuthor(author);
	}
	
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		byte[] buffer = new byte[1024];

		while (!deflater.finished()) {

			int count = deflater.deflate(buffer);

			outputStream.write(buffer, 0, count);

		}

		try {
			outputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

//		System.out.println("Compressed file size in byte- " + outputStream.toByteArray().length);

		return outputStream.toByteArray();

	}

	

}
