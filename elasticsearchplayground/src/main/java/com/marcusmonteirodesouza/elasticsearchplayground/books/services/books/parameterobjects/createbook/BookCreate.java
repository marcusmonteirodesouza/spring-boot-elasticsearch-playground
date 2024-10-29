package com.marcusmonteirodesouza.elasticsearchplayground.books.services.books.parameterobjects.createbook;

import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCreate {
    private String id;

    private String title;

    private Set<String> authors;

    private Set<String> subjects;

    private Map<String, String> formats;

    private Integer downloadCount;
}
