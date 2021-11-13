package ru.fedorov.example.controller.dto.executor.req;

import lombok.Data;
import ru.fedorov.example.controller.dto.album.AlbumDto;

import java.util.List;

@Data
public class NewExecutorReq {

    private List<AlbumDto> albumDtoList;
    private String name;
    private String members;
    private String origin;

}
