package dev.patika.library.service.abstracts;

import dev.patika.library.entity.Book;

public interface IBookService {

    Book save(Book book);
    Book get(long id);
    Book update(Book book);
    boolean delete(long id);

}
