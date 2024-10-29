package com.marcusmonteirodesouza.elasticsearchplayground.books.services.books.repositories.elasticsearch;

import com.marcusmonteirodesouza.elasticsearchplayground.books.models.Book;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticSearchBookRepository extends ElasticsearchRepository<Book, String> {
    List<Book> findByTitleLike(String title);

    List<Book> findByAuthorsLike(String author);

    List<Book> findBySubjectsLike(String subject);

    List<Book> findByTitleLikeOrAuthorsLike(String title, String author);

    List<Book> findByTitleLikeOrSubjectsLike(String title, String subject);

    List<Book> findByAuthorsLikeOrSubjectsLike(String author, String subject);

    List<Book> findByTitleLikeOrAuthorsLikeOrSubjectsLike(
            String title, String author, String subject);
}
