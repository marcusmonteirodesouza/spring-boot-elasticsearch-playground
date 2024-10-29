package com.marcusmonteirodesouza.elasticsearchplayground.books.services.books.parameterobjects.searchbooks;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksSearch {
    private Optional<String> title = Optional.empty();

    private Optional<String> author = Optional.empty();

    private Optional<String> subject = Optional.empty();
}
