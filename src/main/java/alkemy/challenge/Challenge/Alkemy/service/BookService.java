package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Book;
import alkemy.challenge.Challenge.Alkemy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    //Faltan las otras funciones del crud.

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getCollectorPrice(long id){
        Book book = bookRepository.findById(id).get();

        if(book.getEdition()<3 && book.getEdition() > 5 ){
            book.setPrice(book.getPrice()+ book.getPrice()/2);
        }

        return book;
    }
}
