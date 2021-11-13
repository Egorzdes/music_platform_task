package ru.fedorov.example.controller.dto.executor;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import ru.fedorov.example.model.dao.ExecutorDao;



@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExecutorDto {

    private Long executorId;
   // private List<AlbumDto> albumDtoList;
    private String name;
    private String members;
    private String origin;

    public ExecutorDto(ExecutorDao executorDao) {
        this.executorId = executorDao.getId();
        this.members = executorDao.getMembers();
        this.name = executorDao.getName();
        this.origin = executorDao.getOrigin();
    }
}
