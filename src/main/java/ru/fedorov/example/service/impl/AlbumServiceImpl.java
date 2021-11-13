package ru.fedorov.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fedorov.example.controller.dto.album.AlbumDto;
import ru.fedorov.example.service.AlbumService;
import ru.fedorov.example.service.method.AlbumMethod;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumMethod albumMethod;

    @Override
    public AlbumDto getAlbumById(Long albumId) {
        return albumMethod.getAlbum(albumId);
    }
}
