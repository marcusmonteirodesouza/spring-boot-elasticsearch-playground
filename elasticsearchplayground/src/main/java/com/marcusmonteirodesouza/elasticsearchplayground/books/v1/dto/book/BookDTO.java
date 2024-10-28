package com.marcusmonteirodesouza.elasticsearchplayground.books.v1.dto.book;

import java.time.LocalDate;

import com.marcusmonteirodesouza.elasticsearchplayground.books.models.Book;

public record BookDTO(
        String id, String name, String author, LocalDate releaseDate, Integer pageCount) {
    public static BookDTO fromBook(Book book) {
        return new BookDTO(
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getReleaseDate(),
                book.getPageCount());
    }
}
