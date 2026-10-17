package uceva.cleanarchitecture.infrastructure.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uceva.cleanarchitecture.application.usecase.GetAllBooksUseCase;
import uceva.cleanarchitecture.domain.entity.Book;

import java.util.List;

/**
 * Controlador REST de libros. Delega en el caso de uso; no contiene lógica de negocio.
 */
@RestController
@RequestMapping("/books")
@Tag(name = "Books", description = "Operaciones sobre libros")
public class BookController {

    private final GetAllBooksUseCase getAllBooksUseCase;

    public BookController(GetAllBooksUseCase getAllBooksUseCase) {
        this.getAllBooksUseCase = getAllBooksUseCase;
    }

    @GetMapping("/{countBooks}")
    @Operation(summary = "Obtener listado de libros",
            description = "Retorna una lista de libros generados dinámicamente según la cantidad solicitada.")
    public List<Book> getAll(
            @Parameter(description = "Cantidad de libros a generar", example = "10")
            @PathVariable int countBooks) {
        return getAllBooksUseCase.execute(countBooks);
    }
}
