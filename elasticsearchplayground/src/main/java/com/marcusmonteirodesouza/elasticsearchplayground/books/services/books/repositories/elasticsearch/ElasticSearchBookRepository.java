package com.marcusmonteirodesouza.elasticsearchplayground.books.services.books.repositories.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.marcusmonteirodesouza.elasticsearchplayground.books.models.Book;

public interface ElasticSearchBookRepository extends ElasticsearchRepository<Book, String> {}
