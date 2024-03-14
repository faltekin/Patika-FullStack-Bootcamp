package dev.patika.library.service.concretes;

import dev.patika.library.core.exception.NotFoundException;
import dev.patika.library.core.utilities.Msg;
import dev.patika.library.entity.Book;
import dev.patika.library.repository.BookRepository;
import dev.patika.library.service.abstracts.IBookService;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return this.bookRepository.save(book);

    }

    @Override
    public Book get(long id) {
        return this.bookRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));

    }

    @Override
    public Book update(Book book) {
        this.get(book.getId());
        return this.bookRepository.save(book);
    }

    @Override
    public boolean delete(long id) {
        Book book = this.get(id);
        this.bookRepository.delete(book);
        return true;
    }
}
