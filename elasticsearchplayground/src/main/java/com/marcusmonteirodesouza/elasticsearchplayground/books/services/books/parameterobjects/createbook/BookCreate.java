package com.marcusmonteirodesouza.elasticsearchplayground.books.services.books.parameterobjects.createbook;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCreate {
    private String name;

    private String author;

    private LocalDate releaseDate;

    private Integer pageCount;
}
