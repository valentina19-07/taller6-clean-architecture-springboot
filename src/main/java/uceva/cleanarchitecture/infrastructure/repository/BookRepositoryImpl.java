package uceva.cleanarchitecture.infrastructure.repository;

import uceva.cleanarchitecture.domain.entity.Book;
import uceva.cleanarchitecture.domain.repository.BookRepository;
import uceva.cleanarchitecture.infrastructure.datasource.BookDatasource;

import java.util.List;

/**
 * Implementación concreta de BookRepository (capa Infrastructure).
 * Adapta el BookDatasource al contrato del dominio.
 */
public class BookRepositoryImpl extends BookRepository {

    private final BookDatasource bookDatasource;

    public BookRepositoryImpl(BookDatasource bookDatasource) {
        this.bookDatasource = bookDatasource;
    }

    @Override
    public List<Book> getAll(int countBooks) {
        return bookDatasource.getAll(countBooks);
    }
}
