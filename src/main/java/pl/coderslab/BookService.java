package pl.coderslab;

import java.util.List;

public interface BookService {

    List<Book> getList();

    Book getBookById(long id);

    void addBook(Book book);

    void deleteBook(long id);

    void updateBook(Book book);

}
