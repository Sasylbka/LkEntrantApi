package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.DocumentTypeDto;
import ru.esstu.entrant.lk.services.reference.DocumentTypeRefService;

import java.util.List;
@RestController
@Slf4j
public class DocumentTypeRefController {
    /**
     * Сервис.
     */
    private final DocumentTypeRefService documentTypeRefService;

    public DocumentTypeRefController(DocumentTypeRefService documentTypeRefService) {
        this.documentTypeRefService = documentTypeRefService;
    }

        @RequestMapping(method = RequestMethod.GET, path = "/reference/documentType")
    public List<DocumentTypeDto> get() {
        return documentTypeRefService.getDocumentTypes();
    }
}
