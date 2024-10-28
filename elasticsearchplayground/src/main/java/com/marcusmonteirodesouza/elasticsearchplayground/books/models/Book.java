package com.marcusmonteirodesouza.elasticsearchplayground.books.models;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "books")
public class Book {
    @Id private String id;

    private String name;

    private String author;

    @Field(type = FieldType.Date)
    private LocalDate releaseDate;

    private Integer pageCount;
}
