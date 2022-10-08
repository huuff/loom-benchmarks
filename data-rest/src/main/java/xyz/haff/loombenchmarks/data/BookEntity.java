package xyz.haff.loombenchmarks.data;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Builder
@Data
public class BookEntity {
    @Id
    private String id;
    private String title;
    private String author;
}
