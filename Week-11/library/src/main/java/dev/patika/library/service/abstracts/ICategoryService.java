package dev.patika.library.service.abstracts;
import dev.patika.library.entity.Category;

import java.util.List;

public interface ICategoryService {

    Category save(Category category);
    Category get(long id);
    Category update(Category category);
    boolean delete(long id);
    List<Category> getAllById(List<Long> categoryId);

}
