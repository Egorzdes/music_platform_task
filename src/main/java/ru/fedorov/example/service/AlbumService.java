package ru.fedorov.example.service;

import ru.fedorov.example.controller.dto.album.AlbumDto;

public interface AlbumService {

    AlbumDto getAlbumById(Long albumId);
}
