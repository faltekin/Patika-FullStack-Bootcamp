package dev.patika.library.service.concretes;

import dev.patika.library.core.exception.NotFoundException;
import dev.patika.library.core.utilities.Msg;
import dev.patika.library.entity.Author;
import dev.patika.library.repository.AuthorRepository;
import dev.patika.library.service.abstracts.IAuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements IAuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return this.authorRepository.save(author);
    }

    @Override
    public Author get(long id) {
        return this.authorRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Author update(Author author) {
        this.get(author.getId());
        return this.authorRepository.save(author);
    }

    @Override
    public boolean delete(long id) {
        Author author = this.get(id);
        this.authorRepository.delete(author);
        return true;
    }
}
