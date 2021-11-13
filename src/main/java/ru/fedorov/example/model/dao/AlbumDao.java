package ru.fedorov.example.model.dao;


import lombok.*;
import ru.fedorov.example.controller.dto.album.AlbumDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Musical album
 */
@Entity
@Table(name = "album" )
@Getter
@Setter
@NoArgsConstructor
public class AlbumDao implements Serializable {

    private static final long serialVersionUID = 1507632342212393794L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name" )
    private String albumName;
    @Column(name = "tracks" )
    private Long tracks;
    @Column(name = "musicians" )
    private String musicians;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "executor_id" )
    private ExecutorDao idExecutorDao;

    @OneToMany(mappedBy = "albumDao",
            cascade = CascadeType.ALL)
    private List<ProductDao> productDaoList;


    public AlbumDto convertToDto() {
        AlbumDto dto = new AlbumDto();
        dto.setAlbumId(this.id);
        dto.setMusicians(this.musicians);
        dto.setAlbumName(this.albumName);
        dto.setTracks(this.tracks);
        dto.setExecutorName(this.idExecutorDao.getName());
        dto.setProductDtoList(this.productDaoList.stream().map(ProductDao::convertToDto).collect(Collectors.toList()));
        return dto;
    }
}
