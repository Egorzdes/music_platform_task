package ru.fedorov.example.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fedorov.example.controller.dto.album.AlbumDto;
import ru.fedorov.example.controller.dto.executor.ExecutorDto;

import ru.fedorov.example.controller.dto.executor.res.ExecutorIdRes;
import ru.fedorov.example.service.ExecutorService;
import ru.fedorov.example.service.method.ExecutorMethod;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExecutorServiceImpl implements ExecutorService {

    private final ExecutorMethod executorMethod;

    @Override
    public ExecutorIdRes saveExecutor(ExecutorDto req) {
        return executorMethod.save(req);
    }

    @Override
    public ExecutorDto getExecutorById(Long executorId) {
        return executorMethod.getExecutor(executorId);
    }

    @Override
    public List<ExecutorDto> getList() {
        return executorMethod.getList();
    }

    @Override
    public List<AlbumDto> getExecutorsAlbums(Long executorId) {
        return executorMethod.getExecutorsAlbums(executorId);
    }
}
