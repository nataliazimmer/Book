package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockBookService implements BookService {

    private List<Book> list;
    private static Long nextId = 4L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion", "programming"));
    }
    @Override
    public List<Book> getList() {
        return list;
    }

    @Override
    public Book getBookById(long id) {
        for (Book book : getList()) {
            if (id == book.getId()) {
                return book;
            }
        }
        return null;
    }
    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        list.add(book);
    }
    @Override
    public void deleteBook(long id) {
        List<Book> books = getList();
        for (int i = 0; i < books.size(); i++) {
            if (id == books.get(i).getId()) {
                books.remove(i);
                break;
            }
        }
    }
    @Override
    public void updateBook(Book book) {
        List <Book> books = getList();
        for (Book b : books) {
            if (book.getId().equals(book.getId())) {
                b.setIsbn(book.getIsbn());
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setPublisher(book.getPublisher());
                b.setType(book.getType());
                break;
            }
        }
        setList(books);
    }

    private void setList(List<Book> books) {
        this.list=list;
    }
}
