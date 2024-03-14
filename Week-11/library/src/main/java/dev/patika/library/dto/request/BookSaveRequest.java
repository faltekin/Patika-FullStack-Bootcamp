package dev.patika.library.dto.request;

import dev.patika.library.entity.BookBorrowing;
import dev.patika.library.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequest {

    private String name;
    private int publicationYear;
    private int stock;
    private long authorId;
    private long publisherId;
    private List<Category> categoryList;
    private List<BookBorrowing> bookBorrowingList;


}

