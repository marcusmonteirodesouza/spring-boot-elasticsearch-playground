package com.marcusmonteirodesouza.elasticsearchplayground.books.models;

import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "books")
public class Book {
    @Id private String id;

    private String title;

    private Set<String> authors;

    private Set<String> subjects;

    private Map<String, String> formats;

    private Integer downloadCount;
}
