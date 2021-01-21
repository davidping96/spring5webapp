package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        // At runtime when spring gets request to /books it retrieves a list of books from the repository and assigns
        // it to the attribute books on the model.
        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }
}
