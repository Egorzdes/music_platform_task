package ru.fedorov.example.model.dao;


import lombok.*;
import ru.fedorov.example.controller.dto.album.AlbumDto;
import ru.fedorov.example.controller.dto.product.ProductDto;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Musical product
 */
@Table(name = "product" )
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDao implements Serializable {

    private static final long serialVersionUID = 202707941309830865L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name" )
    private String productName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id" )
    private AlbumDao albumDao;

    public ProductDto convertToDto() {
        ProductDto dto = new ProductDto();
        dto.setAlbumId(this.albumDao.getId());
        dto.setProductId(this.id);
        dto.setProductName(this.productName);
        return dto;
    }

}
