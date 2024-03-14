package dev.patika.library.service.abstracts;

import dev.patika.library.entity.Publisher;

public interface IPublisherService {
    Publisher save(Publisher publisher);
    Publisher get(long id);
    Publisher update(Publisher publisher);
    boolean delete(long id);
}
