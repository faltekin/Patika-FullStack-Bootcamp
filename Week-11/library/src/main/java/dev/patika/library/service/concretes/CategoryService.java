package dev.patika.library.service.concretes;

import dev.patika.library.core.exception.NotFoundException;
import dev.patika.library.core.utilities.Msg;
import dev.patika.library.entity.Category;
import dev.patika.library.repository.CategoryRepository;
import dev.patika.library.service.abstracts.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepository.save(category);

    }

    @Override
    public Category get(long id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));

    }

    @Override
    public Category update(Category category) {
        this.get(category.getId());
        return this.categoryRepository.save(category);
    }

    @Override
    public boolean delete(long id) {
        Category category = this.get(id);
        this.categoryRepository.delete(category);
        return true;
    }

    @Override
    public List<Category> getAllById(List<Long> categoryId) {
        return this.categoryRepository.findAllById(categoryId);
    }
}
