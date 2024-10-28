package com.marcusmonteirodesouza.elasticsearchplayground.books.v1.dto.createbook;

import java.time.LocalDate;

public record CreateBookRequestDTO(
        String name, String author, LocalDate releaseDate, Integer pageCount) {}
