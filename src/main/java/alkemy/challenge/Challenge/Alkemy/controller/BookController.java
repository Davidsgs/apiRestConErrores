package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Book;
import alkemy.challenge.Challenge.Alkemy.repository.BookRepository;
import alkemy.challenge.Challenge.Alkemy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    //Faltan las otras funciones del crud.
    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<?> getBooks(){
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.createBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/collectorPrice/book/{id}")
    public ResponseEntity<?> getCollectorPrice (@PathVariable long id){

        return new ResponseEntity<>(bookService.getCollectorPrice(id).getPrice(), HttpStatus.OK);
    }


}
