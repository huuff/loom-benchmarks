package xyz.haff.loombenchmarks.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import xyz.haff.loombenchmarks.data.BookEntity;
import xyz.haff.loombenchmarks.repository.BookRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {
    private final BookRepository repository;

    @Override
    public void run(String... args) {
        if (repository.count() != 0L) // Only if there's no data
            return;

        var book1 = BookEntity.builder()
                .author("author1")
                .title("book1")
                .build();

        var book2 = BookEntity.builder()
                .author("author2")
                .title("book2")
                .build();

        repository.saveAll(List.of(book1, book2));
        log.info("Bootstrapped with " + repository.count() + " entities");
    }
}
