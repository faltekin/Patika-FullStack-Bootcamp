package dev.patika.library.service.concretes;

import dev.patika.library.core.exception.NotFoundException;
import dev.patika.library.core.utilities.Msg;
import dev.patika.library.entity.Publisher;
import dev.patika.library.repository.PublisherRepository;
import dev.patika.library.service.abstracts.IPublisherService;
import org.springframework.stereotype.Service;

@Service
public class PublisherService implements IPublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return this.publisherRepository.save(publisher);
    }

    @Override
    public Publisher get(long id) {
        return this.publisherRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Publisher update(Publisher publisher) {
        this.get(publisher.getId());
        return this.publisherRepository.save(publisher);
    }

    @Override
    public boolean delete(long id) {
        Publisher publisher = this.get(id);
        this.publisherRepository.delete(publisher);
        return true;
    }
}
