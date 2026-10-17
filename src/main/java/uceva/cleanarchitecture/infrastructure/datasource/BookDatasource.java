package uceva.cleanarchitecture.infrastructure.datasource;

import com.github.javafaker.Faker;
import uceva.cleanarchitecture.domain.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Datasource que genera libros simulados con JavaFaker (capa Infrastructure).
 */
public class BookDatasource {

    private final Faker faker = new Faker();
    private final Random random = new Random();
    private final String[] genres = {
            "Ficcion",
            "Ciencia",
            "Historia",
            "Tecnologia"
    };

    public List<Book> getAll(int countBooks) {
        List<Book> books = new ArrayList<>();
        for (int i = 1; i <= countBooks; i++) {
            books.add(generateBook(i));
        }
        return books;
    }

    private Book generateBook(Integer id) {
        return new Book(
                id,
                faker.book().title(),
                faker.book().author(),
                randomGenre(),
                faker.number().numberBetween(1950, 2024)
        );
    }

    private String randomGenre() {
        return genres[random.nextInt(genres.length)];
    }
}
