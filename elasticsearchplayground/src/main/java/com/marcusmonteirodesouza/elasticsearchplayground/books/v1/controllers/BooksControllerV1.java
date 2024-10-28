package com.marcusmonteirodesouza.elasticsearchplayground.books.v1.controllers;

import com.marcusmonteirodesouza.elasticsearchplayground.books.services.books.BooksService;
import com.marcusmonteirodesouza.elasticsearchplayground.books.services.books.parameterobjects.createbook.BookCreate;
import com.marcusmonteirodesouza.elasticsearchplayground.books.v1.dto.book.BookDTO;
import com.marcusmonteirodesouza.elasticsearchplayground.books.v1.dto.createbook.CreateBookRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
                                request.name(),
                                request.author(),
                                request.releaseDate(),
                                request.pageCount()));

        return BookDTO.fromBook(book);
    }
}
