package com.marcusmonteirodesouza.elasticsearchplayground.books.v1.dto.book;

import com.marcusmonteirodesouza.elasticsearchplayground.books.models.Book;
import java.util.Map;
import java.util.Set;

public record BookDTO(
        String id,
        String title,
        Set<String> authors,
        Set<String> subjects,
        Map<String, String> formats,
        Integer downloadCount) {
    public static BookDTO fromBook(Book book) {
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthors(),
                book.getSubjects(),
                book.getFormats(),
                book.getDownloadCount());
    }
}
