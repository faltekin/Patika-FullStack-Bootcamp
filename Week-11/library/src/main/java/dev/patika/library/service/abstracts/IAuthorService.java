package dev.patika.library.service.abstracts;

import dev.patika.library.entity.Author;

public interface IAuthorService {
    Author save(Author author);
    Author get(long id);
    Author update(Author author);
    boolean delete(long id);
}
