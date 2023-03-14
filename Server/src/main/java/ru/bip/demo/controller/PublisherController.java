package ru.bip.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bip.demo.entity.PublisherEntity;
import ru.bip.demo.exception.ValidationExceptionPublisher;
import ru.bip.demo.response.BaseResponse;
import ru.bip.demo.response.PublisherListResponse;
import ru.bip.demo.response.PublisherResponse;
import ru.bip.demo.service.PublisherService;
import ru.bip.demo.utils.PublisherValidationUtils;

@RestController
@RequestMapping("api/v1/publisher")
public class PublisherController {
    private final PublisherService service;

    private PublisherController(PublisherService service){
        this.service = service;
    }


    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(@RequestBody PublisherEntity pub){
        try {
            PublisherValidationUtils.validatePub(pub);
            PublisherEntity publ = service.save(pub);
            return ResponseEntity.ok(new PublisherResponse(true,"Издательство добавлено",publ));
        }catch(ValidationExceptionPublisher e){
            return ResponseEntity.badRequest().body(new PublisherResponse(false, e.getMessage(), null));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){
        return ResponseEntity.ok(new PublisherListResponse(service.getAll()));
    }
    @PutMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody PublisherEntity pub){
        try {
            PublisherValidationUtils.validatePub(pub);
            PublisherEntity publ = service.save(pub);
            return ResponseEntity.ok(new PublisherResponse(true, "В издательство внесены изменения", publ));
        }catch (ValidationExceptionPublisher e){
            return ResponseEntity.badRequest().body(new BaseResponse(false,"Издательство осталось прежним."));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Издательство удалено"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, "Издательство не найдено в базе"));
        }
    }

}
