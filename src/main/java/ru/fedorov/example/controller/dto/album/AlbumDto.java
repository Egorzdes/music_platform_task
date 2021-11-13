package ru.fedorov.example.controller.dto.album;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fedorov.example.controller.dto.product.ProductDto;
import ru.fedorov.example.model.dao.AlbumDao;
import ru.fedorov.example.model.dao.ProductDao;


import java.util.List;
import java.util.stream.Collectors;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class AlbumDto {

    private String executorName;
    private Long albumId;
    private String albumName;
    private Long tracks;
    private String musicians;
    private List<ProductDto> productDtoList;

    public AlbumDto(AlbumDao albumDao) {
        this.albumId = albumDao.getId();
        this.albumName = albumDao.getAlbumName();
        this.executorName = albumDao.getIdExecutorDao().getName();
        this.musicians = albumDao.getMusicians();
        this.productDtoList = albumDao.getProductDaoList().stream()
                .map(ProductDao::convertToDto).collect(Collectors.toList());
    }
}
