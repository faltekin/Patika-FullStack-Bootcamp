package dev.patika.library.service.concretes;

import dev.patika.library.core.exception.NotFoundException;
import dev.patika.library.core.utilities.Msg;
import dev.patika.library.entity.BookBorrowing;
import dev.patika.library.repository.BookBorrowingRepository;
import dev.patika.library.service.abstracts.IBookBorrowingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowingService implements IBookBorrowingService {

    private final BookBorrowingRepository bookBorrowingRepository;

    public BookBorrowingService(BookBorrowingRepository bookBorrowingRepository) {
        this.bookBorrowingRepository = bookBorrowingRepository;
    }

    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {
        return this.bookBorrowingRepository.save(bookBorrowing);
    }

    @Override
    public BookBorrowing get(long id) {
        return this.bookBorrowingRepository.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));

    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
        this.get(bookBorrowing.getId());
        return this.bookBorrowingRepository.save(bookBorrowing);
    }

    @Override
    public boolean delete(long id) {
        BookBorrowing bookBorrowing = this.get(id);
        this.bookBorrowingRepository.delete(bookBorrowing);
        return true;
    }

    @Override
    public List<BookBorrowing> getAll() {
        return this.bookBorrowingRepository.findAll();
    }
}
