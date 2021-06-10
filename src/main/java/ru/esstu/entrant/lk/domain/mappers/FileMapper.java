package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.FileDto;
import ru.esstu.entrant.lk.domain.vo.File;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class FileMapper {
    public FileDto toDto(File vo) {
        if (vo == null) {
            return null;
        }
        return new FileDto(
                vo.getId(),
                vo.getEntrantId(),
                vo.getFileName(),
                vo.getFileExtension(),
                vo.getDocumentType(),
                vo.getGuid()
        );
    }

    public File toVO(FileDto dto) {
        if (dto == null) {
            return null;
        }
        return new File(
                dto.getId(),
                dto.getEntrantId(),
                dto.getFileName(),
                dto.getFileExtension(),
                dto.getDocumentType(),
                dto.getGuid()
        );
    }
    public List<FileDto> toDtos (List<File> vos) {
        List<FileDto> list = new ArrayList<>();
        for (File vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
