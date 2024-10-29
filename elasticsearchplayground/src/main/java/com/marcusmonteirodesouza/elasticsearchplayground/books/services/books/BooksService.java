package com.marcusmonteirodesouza.elasticsearchplayground.books.services.books;

import com.marcusmonteirodesouza.elasticsearchplayground.books.models.Book;
import com.marcusmonteirodesouza.elasticsearchplayground.books.repositories.elasticsearch.ElasticSearchBookRepository;
import com.marcusmonteirodesouza.elasticsearchplayground.books.services.books.parameterobjects.createbook.BookCreate;
import com.marcusmonteirodesouza.elasticsearchplayground.books.services.books.parameterobjects.searchbooks.BooksSearch;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class BooksService {
    private final ElasticSearchBookRepository elasticSearchBookRepository;

    public Book createBook(BookCreate bookCreate) {
        var book = new Book();
        book.setId(bookCreate.getId());
        book.setTitle(bookCreate.getTitle());
        book.setAuthors(bookCreate.getAuthors());
        book.setSubjects(bookCreate.getSubjects());
        book.setFormats(bookCreate.getFormats());
        book.setDownloadCount(bookCreate.getDownloadCount());

        log.info("Creating book: {}", book);

        return elasticSearchBookRepository.save(book);
    }

    public List<Book> searchBooks(BooksSearch booksSearch) {
        var titleOpt = booksSearch.getTitle();

        var authorOpt = booksSearch.getAuthor();

        var subjectOpt = booksSearch.getSubject();

        if (titleOpt.isPresent() && authorOpt.isPresent() && subjectOpt.isPresent()) {
            return elasticSearchBookRepository.findByTitleLikeOrAuthorsLikeOrSubjectsLike(
                    titleOpt.get(), authorOpt.get(), subjectOpt.get());
        }

        if (titleOpt.isPresent() && authorOpt.isPresent()) {
            return elasticSearchBookRepository.findByTitleLikeOrAuthorsLike(
                    titleOpt.get(), authorOpt.get());
        }

        if (titleOpt.isPresent() && subjectOpt.isPresent()) {
            return elasticSearchBookRepository.findByTitleLikeOrSubjectsLike(
                    titleOpt.get(), subjectOpt.get());
        }

        if (authorOpt.isPresent() && subjectOpt.isPresent()) {
            return elasticSearchBookRepository.findByAuthorsLikeOrSubjectsLike(
                    authorOpt.get(), subjectOpt.get());
        }

        if (titleOpt.isPresent()) {
            return elasticSearchBookRepository.findByTitleLike(titleOpt.get());
        }

        if (authorOpt.isPresent()) {
            return elasticSearchBookRepository.findByAuthorsLike(authorOpt.get());
        }

        if (subjectOpt.isPresent()) {
            return elasticSearchBookRepository.findBySubjectsLike(subjectOpt.get());
        }

        return elasticSearchBookRepository.findAll(Pageable.unpaged()).toList();
    }
}
