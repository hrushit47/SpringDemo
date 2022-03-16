package book.Book;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return Arrays.asList(new Book(1l, "Mastering Spring 5.1" , "Ranga karanam "),
				new Book(2l, "Mastering Spring 5.2" , "Hrushi Thakur "),
				new Book(3l, "Mastering Spring 5.3" , "Kunal Zurange "));
	}
	
	

}
