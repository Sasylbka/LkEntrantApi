package ru.esstu.entrant.lk.services.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.DocumentTypeDto;
import ru.esstu.entrant.lk.domain.mappers.reference.DocumentTypeRefMapper;
import ru.esstu.entrant.lk.repositories.reference.DocumentTypeRefRepository;

import java.util.List;
@Service
@Slf4j
public class DocumentTypeRefService {
    private final DocumentTypeRefRepository documentTypeRefRepository;
    private final DocumentTypeRefMapper documentTypeRefMapper;

    public DocumentTypeRefService(DocumentTypeRefRepository documentTypeRefRepository,
                                        DocumentTypeRefMapper documentTypeRefMapper) {
        this.documentTypeRefRepository = documentTypeRefRepository;
        this.documentTypeRefMapper = documentTypeRefMapper;
    }

    public List<DocumentTypeDto> getDocumentTypes() {
        return documentTypeRefMapper.toDtos(documentTypeRefRepository.getDocumentTypes());
    }
}
