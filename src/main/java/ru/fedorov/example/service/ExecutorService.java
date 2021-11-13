package ru.fedorov.example.service;


import ru.fedorov.example.controller.dto.album.AlbumDto;
import ru.fedorov.example.controller.dto.executor.ExecutorDto;
import ru.fedorov.example.controller.dto.executor.res.ExecutorIdRes;


import java.util.List;

public interface ExecutorService {

    ExecutorIdRes saveExecutor(ExecutorDto req);

    ExecutorDto getExecutorById(Long executorId);

    List<ExecutorDto> getList();

    List<AlbumDto> getExecutorsAlbums(Long executorId);
}
