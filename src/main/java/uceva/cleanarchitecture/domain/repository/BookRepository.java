package uceva.cleanarchitecture.domain.repository;

import uceva.cleanarchitecture.domain.entity.Book;

import java.util.List;

/**
 * Contrato del repositorio de libros (capa Domain).
 */
public abstract class BookRepository {
    public abstract List<Book> getAll(int countBooks);
}
