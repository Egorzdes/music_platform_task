package ru.fedorov.example.service.method;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.fedorov.example.controller.dto.album.AlbumDto;
import ru.fedorov.example.exception.Exception;
import ru.fedorov.example.exception.MyErrors;
import ru.fedorov.example.model.repository.AlbumRepository;

@Component
@AllArgsConstructor
public class AlbumMethod {

    private final AlbumRepository albumRepository;

    public AlbumDto getAlbum(Long albumId) {
        return albumRepository.findById(albumId)
                .map(AlbumDto::new)
                .orElseThrow(() -> new Exception(MyErrors.EXECUTOR_WITHOUT_ALBUM));
    }
}
