package com.marcusmonteirodesouza.elasticsearchplayground.books.services.books;

import com.marcusmonteirodesouza.elasticsearchplayground.books.models.Book;
import com.marcusmonteirodesouza.elasticsearchplayground.books.services.books.parameterobjects.createbook.BookCreate;
import com.marcusmonteirodesouza.elasticsearchplayground.books.services.books.repositories.elasticsearch.ElasticSearchBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BooksService {
    private final ElasticSearchBookRepository elasticSearchBookRepository;

    public Book createBook(BookCreate bookCreate) {
        var book = new Book();
        book.setName(bookCreate.getName());
        book.setAuthor(bookCreate.getAuthor());
        book.setPageCount(bookCreate.getPageCount());

        return elasticSearchBookRepository.save(book);
    }
}
