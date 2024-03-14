package dev.patika.library.controller;


import dev.patika.library.core.config.modelMapper.IModelMapperService;
import dev.patika.library.core.result.Result;
import dev.patika.library.core.result.ResultData;
import dev.patika.library.core.utilities.ResultHelper;
import dev.patika.library.dto.request.AuthorUpdateRequest;
import dev.patika.library.dto.request.BookSaveRequest;
import dev.patika.library.dto.response.AuthorResponse;
import dev.patika.library.dto.response.BookResponse;
import dev.patika.library.dto.response.CategoryResponse;
import dev.patika.library.entity.Author;
import dev.patika.library.entity.Book;
import dev.patika.library.entity.Publisher;
import dev.patika.library.service.abstracts.IAuthorService;
import dev.patika.library.service.abstracts.IBookService;
import dev.patika.library.service.abstracts.IPublisherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/books")
public class BookController {

    private final IBookService bookService;

    private final IAuthorService authorService;

    private final IPublisherService publisherService;

    private final IModelMapperService modelMapper;


    public BookController(IBookService bookService, IAuthorService authorService, IPublisherService publisherService, IModelMapperService modelMapper) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> get(@PathVariable("id") int id){
        Book book = this.bookService.get(id);
        BookResponse bookResponse = this.modelMapper.forResponse().map(book, BookResponse.class);
        return ResultHelper.success(bookResponse);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest) {
        Book saveBook = this.modelMapper.forRequest().map(bookSaveRequest, Book.class);

        Author author = this.authorService.get(bookSaveRequest.getAuthorId());
        saveBook.setAuthor(author);

        Publisher publisher = this.publisherService.get(bookSaveRequest.getPublisherId());
        saveBook.setPublisher(publisher);

        this.bookService.save(saveBook);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveBook, BookResponse.class));
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> update(@Valid @RequestBody AuthorUpdateRequest authorUpdateRequest) {
        Author updateAuthor = this.modelMapper.forRequest().map(authorUpdateRequest, Author.class);
        this.authorService.update(updateAuthor);
        return ResultHelper.created(this.modelMapper.forResponse().map(updateAuthor, AuthorResponse.class));
    }
    @GetMapping("/{id}/category")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> getCategory(@PathVariable("id") int id){
        Book book = this.bookService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(book.getCategoryList(), CategoryResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.authorService.delete(id);
        return ResultHelper.Ok();
    }
}
