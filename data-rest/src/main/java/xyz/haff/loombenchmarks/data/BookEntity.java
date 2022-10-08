package xyz.haff.loombenchmarks.data;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@NoArgsConstructor
@Data
public class BookEntity {
    @Id
    private String id;

    // TODO: bind by name
    @CsvBindByPosition(position = 3)
    private String title;
    // TODO: as LocalDate
    @CsvBindByPosition(position = 2)
    private String date;
    @CsvBindByPosition(position = 4)
    private String language;
    // TODO: as list
    @CsvBindByPosition(position = 5)
    private String authors;
}
