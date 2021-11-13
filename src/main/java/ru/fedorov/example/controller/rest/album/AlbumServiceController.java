package ru.fedorov.example.controller.rest.album;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fedorov.example.controller.ResponseBuilder;
import ru.fedorov.example.model.repository.AlbumRepository;
import ru.fedorov.example.service.AlbumService;

@RestController
@RequestMapping(value = "/album" )
@RequiredArgsConstructor
@Slf4j
public class AlbumServiceController {

    private final AlbumService albumService;
    private final AlbumRepository albumRepository;

    @GetMapping(value = "/{albumId}" )
    public ResponseEntity<?> getAlbumById(@PathVariable("albumId" ) Long albumId) {
        if (!albumRepository.existsById(albumId)) {
            return new ResponseEntity<>("Album with id " + albumId + " not found",
                    HttpStatus.NOT_FOUND);
        } else {
            return ResponseBuilder.build(albumService.getAlbumById(albumId));
        }
    }
}
