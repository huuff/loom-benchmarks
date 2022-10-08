package xyz.haff.loombenchmarks.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import xyz.haff.loombenchmarks.data.BookEntity;

@RepositoryRestResource(collectionResourceRel = "book", path = "book")
public interface BookRepository extends MongoRepository<BookEntity, String> {
}
