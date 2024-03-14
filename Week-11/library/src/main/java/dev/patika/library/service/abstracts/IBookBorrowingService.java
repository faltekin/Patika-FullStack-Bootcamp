package dev.patika.library.service.abstracts;

import dev.patika.library.entity.BookBorrowing;

import java.util.List;

public interface IBookBorrowingService {

    BookBorrowing save(BookBorrowing bookBorrowing);
    BookBorrowing get(long id);

    BookBorrowing update(BookBorrowing bookBorrowing);
    boolean delete(long id);
    List<BookBorrowing> getAll();


}
