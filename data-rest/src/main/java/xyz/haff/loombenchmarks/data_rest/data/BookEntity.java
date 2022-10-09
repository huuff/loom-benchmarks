package xyz.haff.loombenchmarks.data_rest.data;

import com.opencsv.bean.CsvBindByName;
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

    @CsvBindByName(column = "Title")
    private String title;
    // TODO: as LocalDate
    @CsvBindByName(column = "Issued")
    private String date;
    @CsvBindByName(column = "Language")
    private String language;
    // TODO: as list
    @CsvBindByName(column = "Authors")
    private String authors;
}
