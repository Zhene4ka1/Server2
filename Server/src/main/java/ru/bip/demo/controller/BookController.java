package ru.bip.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bip.demo.entity.AuthorEntity;
import ru.bip.demo.entity.BookEntity;
import ru.bip.demo.entity.PublisherEntity;
import ru.bip.demo.exception.ValidationExceptionAuthor;
import ru.bip.demo.exception.ValidationExceptionBook;
import ru.bip.demo.exception.ValidationExceptionPublisher;
import ru.bip.demo.response.*;
import ru.bip.demo.service.BookService;
import ru.bip.demo.utils.AuthorValidationUtils;
import ru.bip.demo.utils.BookValidationUtils;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService service;

    private BookController(BookService service){
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(@RequestBody BookEntity book){
        try {
            BookValidationUtils.validateBook(book);
            BookEntity temp = service.save(book);
            return ResponseEntity.ok(new BookResponse(true,"Книга добавлена",book));
        }catch(ValidationExceptionBook e){
            return ResponseEntity.badRequest().body(new BookResponse(false, e.getMessage(), null));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){
        return ResponseEntity.ok(new BookListResponse(service.getAll()));
    }

        @PutMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody BookEntity data){
            try {
                BookEntity temp=service.save(data);
                AuthorValidationUtils.validationAuthor(temp.getAuthor());
                return ResponseEntity.ok(new BookResponse(true,"В книгу внесены изменения",temp));
            }catch(ValidationExceptionBook e){

                return ResponseEntity.badRequest().body(new BookResponse(false, "В книгу не внесены изменения",null));
            }
            catch (Exception e){
                return ResponseEntity.badRequest().body(new BaseResponse(false,"В книгу не внесены изменения"));
            }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Книга удалена"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, "Книга не удалена"));
        }
    }




     @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable long id){
        try {
            BookEntity book = service.find(id);
            return ResponseEntity.ok(new BookResponse(true,"Книга найдена",book));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new BookResponse(false, "Книга не найдена",null));
        }
    }

   /*@PostMapping("/add")
    public ResponseEntity<BookResponse> registration(@RequestBody BookEntity data){
        try {
                BookEntity temp=service.save(data);
                return ResponseEntity.ok(new BookResponse(true,"Книга добавлена",temp));
            }catch(Exception e){
                return ResponseEntity.badRequest().body(new BookResponse(false, e.getMessage(), null));
            }
        }*/
}
