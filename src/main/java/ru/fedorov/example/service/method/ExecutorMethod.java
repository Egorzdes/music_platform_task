package ru.fedorov.example.service.method;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ru.fedorov.example.controller.dto.album.AlbumDto;
import ru.fedorov.example.controller.dto.executor.ExecutorDto;
import ru.fedorov.example.controller.dto.executor.res.ExecutorIdRes;
import ru.fedorov.example.exception.Exception;
import ru.fedorov.example.exception.MyErrors;
import ru.fedorov.example.model.dao.AlbumDao;
import ru.fedorov.example.model.dao.ExecutorDao;
import ru.fedorov.example.model.repository.AlbumRepository;
import ru.fedorov.example.model.repository.ExecutorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class ExecutorMethod {

    private final ExecutorRepository executorRepository;
    private final AlbumRepository albumRepository;

    public ExecutorIdRes save(ExecutorDto req) {
        ExecutorDao executorDao = new ExecutorDao(req);
        ExecutorDao savedExecutorDao = executorRepository.save(executorDao);
        ExecutorIdRes executorIdRes = new ExecutorIdRes();
        executorIdRes.setExecutorId(savedExecutorDao.getId());
        return executorIdRes;
    }

    public ExecutorDto getExecutor(Long executorId) {
        return executorRepository.findById(executorId)
                .map(ExecutorDto::new)
                .orElseThrow(() -> new Exception(MyErrors.EXECUTOR_NOT_FOUND));
    }


    public List<ExecutorDto> getList() {
        List<ExecutorDto> res = new ArrayList<>();
        List<ExecutorDao> executorDaos;
        executorDaos = executorRepository.findAll();
        if (executorDaos.size() > 0) {
            res = executorDaos.stream().map(ExecutorDto::new).collect(Collectors.toList());
        }
        return res;
    }

    public List<AlbumDto> getExecutorsAlbums(Long executorId) {
        List<AlbumDto> albums;
        executorRepository.findById(executorId)
                .orElseThrow(() -> new Exception(MyErrors.EXECUTOR_NOT_FOUND));
        albums = convertList(albumRepository.findByIdExecutor(executorId));
        if (CollectionUtils.isEmpty(albums)) {
            throw new Exception(MyErrors.EXECUTOR_WITHOUT_ALBUM);
        }
        return albums;
    }


    private List<AlbumDto> convertList(List<AlbumDao> albumDaoList) {
        return albumDaoList.stream().map(AlbumDao::convertToDto).collect(Collectors.toList());
    }
}
