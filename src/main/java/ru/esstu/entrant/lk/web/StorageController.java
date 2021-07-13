package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.esstu.entrant.lk.domain.dto.FileDto;
import ru.esstu.entrant.lk.domain.vo.Message;
import ru.esstu.ls.aicstorages.general.is.IStorageConnector;
import ru.esstu.ls.aicstorages.general.is.StorageFile;
import ru.esstu.entrant.lk.services.FileService;

import java.util.ArrayList;
import java.util.List;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class StorageController {

    /**
     * Сервис.
     */
    private IStorageConnector storageConnector;
    private FileService fileService;
    public StorageController(IStorageConnector storageConnector, FileService fileService) {
        this.storageConnector = storageConnector;
        this.fileService=fileService;
    }
    @RequestMapping(value = "/file/save.do", method = RequestMethod.POST)
    public FileDto save(@RequestParam(required = false) MultipartFile file, String type, int entrantId) {
        String fileCode = "";
        if (file != null && !file.isEmpty()) {
            fileCode = storageConnector.saveFile(file);
        }
        String filename= file.getOriginalFilename();
        String contentType = file.getContentType();
        return fileService.save(fileCode,type,entrantId,filename,contentType);
    }
    @RequestMapping(value = "/file/saveInMessage.do", method = RequestMethod.POST)
    public void saveMessage(@RequestParam(required = false) MultipartFile file, int entrantId,int dialogId,String role,String message) {
        String fileCode = "";
        if (file != null && !file.isEmpty()) {
            fileCode = storageConnector.saveFile(file);
        }
        String filename= file.getOriginalFilename();
        String contentType = file.getContentType();
        fileService.saveInMessage(fileCode,"GET_FROM_MESSAGE",entrantId,filename,contentType,dialogId,role,message,filename);
    }
    @RequestMapping(value = "/file/delete.do",method = RequestMethod.POST)
    public void delete(@RequestParam(required = false)String guid,int idForDelete){
        String fileCode=guid;
        storageConnector.removeFileSafety(fileCode);
        fileService.delete(idForDelete);
    }
}
