package com.marcusmonteirodesouza.elasticsearchplayground.books.v1.controllers;

import com.marcusmonteirodesouza.elasticsearchplayground.books.services.books.BooksService;
import com.marcusmonteirodesouza.elasticsearchplayground.books.services.books.parameterobjects.createbook.BookCreate;
import com.marcusmonteirodesouza.elasticsearchplayground.books.services.books.parameterobjects.searchbooks.BooksSearch;
import com.marcusmonteirodesouza.elasticsearchplayground.books.v1.dto.book.BookDTO;
import com.marcusmonteirodesouza.elasticsearchplayground.books.v1.dto.createbook.CreateBookRequestDTO;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/books")
@AllArgsConstructor
public class BooksControllerV1 {
    private final BooksService booksService;

    @PostMapping
    public BookDTO createBook(@RequestBody CreateBookRequestDTO request) {
        var book =
                booksService.createBook(
                        new BookCreate(
                                request.id(),
                                request.title(),
                                request.authors(),
                                request.subjects(),
                                request.formats(),
                                request.downloadCount()));

        return BookDTO.fromBook(book);
    }

    @GetMapping("/search")
    public List<BookDTO> searchBooks(
            @RequestParam Optional<String> title,
            @RequestParam Optional<String> author,
            @RequestParam Optional<String> subject) {
        var booksSearch = new BooksSearch();
        booksSearch.setTitle(title);
        booksSearch.setAuthor(author);
        booksSearch.setSubject(subject);

        var books = booksService.searchBooks(booksSearch);

        return books.stream().map(BookDTO::fromBook).toList();
    }
}
