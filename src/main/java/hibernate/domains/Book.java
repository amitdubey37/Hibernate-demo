package hibernate.domains;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amit Dubey on 21/1/17.
 */
@Entity
public class Book {
    String bookName;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Integer bookId;
    @ManyToMany(mappedBy = "books")
    List<Author> authors = new ArrayList<Author>();

    public Integer getBookId() {
        return bookId;
    }

    public List<Author> getAuthorList() {
        return authors;
    }

    public void setAuthorList(List<Author> authors) {
        this.authors = authors;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
