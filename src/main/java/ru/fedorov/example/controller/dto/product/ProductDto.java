package ru.fedorov.example.controller.dto.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    private Long productId;
    private Long albumId;
    private String productName;
}
