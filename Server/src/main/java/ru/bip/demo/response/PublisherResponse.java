package ru.bip.demo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.bip.demo.entity.PublisherEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class PublisherResponse extends BaseResponse {
    public PublisherResponse(boolean success, String message, PublisherEntity publisher){
        super(success,message);
        this.publisher= publisher;
    }
    public PublisherResponse(PublisherEntity publisher){
        super(true,"Данные издательства");
    }
    private PublisherEntity publisher;
}
