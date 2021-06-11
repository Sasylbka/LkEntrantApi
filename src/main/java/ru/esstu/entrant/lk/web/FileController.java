package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.FileDto;
import ru.esstu.entrant.lk.services.FileService;

import java.util.List;

@RestController
@Slf4j
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/file")
    public List<FileDto> get(final int id) {

        return fileService.getFiles(id);
    }
}
