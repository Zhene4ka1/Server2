package ru.bip.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bip.demo.entity.AuthorEntity;
import ru.bip.demo.entity.PublisherEntity;
import ru.bip.demo.exception.ValidationExceptionAuthor;
import ru.bip.demo.exception.ValidationExceptionPublisher;
import ru.bip.demo.response.*;
import ru.bip.demo.service.AuthorService;
import ru.bip.demo.service.PublisherService;
import ru.bip.demo.utils.AuthorValidationUtils;
import ru.bip.demo.utils.PublisherValidationUtils;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
    private final AuthorService service;

    private AuthorController(AuthorService service){
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(@RequestBody AuthorEntity author){
        try {
            AuthorValidationUtils.validationAuthor(author);
            AuthorEntity temp = service.save(author);
            return ResponseEntity.ok(new AuthorResponse(true,"Автор добавлен",temp));
        }catch(ValidationExceptionAuthor e){
            return ResponseEntity.badRequest().body(new AuthorResponse(false, e.getMessage(), null));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){
        return ResponseEntity.ok(new AuthorListResponse(service.getAll()));
    }
    @PutMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody AuthorEntity author){
        try {
            AuthorValidationUtils.validationAuthor(author);
            AuthorEntity auth = service.save(author);
            return ResponseEntity.ok(new AuthorResponse(true, "В данные автора внесены изменения", auth));
        }catch (ValidationExceptionPublisher e){
            return ResponseEntity.badRequest().body(new BaseResponse(false,"Автор остался прежним."));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false,"Автор остался прежним."));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Автор удален"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, "Автор не найден в базе"));
        }
    }
}
