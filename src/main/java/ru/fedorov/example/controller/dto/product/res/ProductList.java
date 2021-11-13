package ru.fedorov.example.controller.dto.product.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import ru.fedorov.example.controller.dto.product.ProductDto;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductList {

    List<ProductDto> productDtoList;
}
