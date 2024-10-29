package com.marcusmonteirodesouza.elasticsearchplayground.books.v1.dto.createbook;

import java.util.Map;
import java.util.Set;

public record CreateBookRequestDTO(
        String id,
        String title,
        Set<String> authors,
        Set<String> subjects,
        Map<String, String> formats,
        Integer downloadCount) {}
