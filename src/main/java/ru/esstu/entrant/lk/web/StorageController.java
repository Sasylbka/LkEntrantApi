package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.esstu.ls.aicstorages.general.is.IStorageConnector;
import ru.esstu.ls.aicstorages.general.is.StorageFile;

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

    public StorageController(IStorageConnector storageConnector) {
        this.storageConnector = storageConnector;
    }

    @RequestMapping(value = "/file/save.do", method = RequestMethod.POST)
    public void save(@RequestParam(required = false) MultipartFile file) {
        String fileCode = "";
        if (file != null && !file.isEmpty()) {
            fileCode = storageConnector.saveFile(file);
            System.out.println(fileCode);

        }
        StorageFile storageFile = storageConnector.getStorageFile(fileCode);
        System.out.println(storageFile.getStoragePath() + storageFile.getRelativtyPath() + storageFile.getFileName());
    }
}
