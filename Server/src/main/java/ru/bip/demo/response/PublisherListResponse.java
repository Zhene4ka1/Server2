package ru.bip.demo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.bip.demo.entity.PublisherEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class PublisherListResponse extends  BaseResponse {
    public PublisherListResponse(Iterable<PublisherEntity> data) {
        super(true, "Издательства");
        this.data = data;
    }

    private Iterable<PublisherEntity> data;
}
