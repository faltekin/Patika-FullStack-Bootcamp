package dev.patika.library.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherResponse {

    private long id;
    private String name;
    private int establishmentYear;
    private String address;

}
