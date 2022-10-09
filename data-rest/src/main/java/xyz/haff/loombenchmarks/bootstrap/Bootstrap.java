package xyz.haff.loombenchmarks.bootstrap;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import xyz.haff.loombenchmarks.data.BookEntity;
import xyz.haff.loombenchmarks.repository.BookRepository;

import java.io.FileReader;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {
    private final BookRepository repository;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() != 0L) // Only if there's no data
            return;

        List<BookEntity> books = new CsvToBeanBuilder<BookEntity>(
                new FileReader(getClass().getClassLoader().getResource("gutenberg_index.csv").getFile())
        ).withType(BookEntity.class).build().parse();

        repository.saveAll(books);
        log.info("Bootstrapped with " + repository.count() + " entities");
    }
}
