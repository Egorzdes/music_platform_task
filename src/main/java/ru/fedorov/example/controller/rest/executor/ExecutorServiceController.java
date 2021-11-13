package ru.fedorov.example.controller.rest.executor;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fedorov.example.controller.ResponseBuilder;
import ru.fedorov.example.controller.dto.executor.ExecutorDto;
import ru.fedorov.example.model.repository.ExecutorRepository;
import ru.fedorov.example.service.ExecutorService;


@RestController
@RequestMapping(value = "/executor" )
@RequiredArgsConstructor
@Slf4j
public class ExecutorServiceController {

    private final ExecutorService executorService;
    private final ExecutorRepository executorRepository;

    @GetMapping(value = "/{executorId}" )
    public ResponseEntity<?> getExecutorById(@PathVariable("executorId" ) Long executorId) {
        if (!executorRepository.existsById(executorId)) {
            return new ResponseEntity<>("Executor with id " + executorId + " not found",
                    HttpStatus.NOT_FOUND);
        } else {
            return ResponseBuilder.build(executorService.getExecutorById(executorId));
        }
    }

    @GetMapping(value = "/list" )
    public ResponseEntity<?> list() {
        return ResponseBuilder.build(executorService.getList());
    }

    @PostMapping(value = "/" )
    public ResponseEntity<?> saveExecutor(@RequestBody ExecutorDto req) {
        return ResponseBuilder.build(executorService.saveExecutor(req));
    }

    @GetMapping(value = "/albums/{executorId}" )
    public ResponseEntity<?> getExecutorAlbums(@PathVariable("executorId" ) Long executorId) {
        if(!executorRepository.existsById(executorId)) {
            return new ResponseEntity<>("Albums of executor with id " + executorId + " not found",
                    HttpStatus.NOT_FOUND);
        }
        return ResponseBuilder.build(executorService.getExecutorsAlbums(executorId));
    }


}
