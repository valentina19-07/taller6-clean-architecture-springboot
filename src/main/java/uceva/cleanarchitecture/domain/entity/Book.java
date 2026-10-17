package uceva.cleanarchitecture.domain.entity;

/**
 * Entidad que representa un libro del sistema (capa Domain).
 */
public class Book {
    public Integer id;
    public String title;
    public String author;
    public String genre;
    public Integer year;

    public Book(Integer id, String title, String author, String genre, Integer year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }
}
