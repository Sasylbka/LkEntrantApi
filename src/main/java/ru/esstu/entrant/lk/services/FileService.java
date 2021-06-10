package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.FileDto;
import ru.esstu.entrant.lk.domain.dto.FileDto;
import ru.esstu.entrant.lk.domain.mappers.FileMapper;
import ru.esstu.entrant.lk.domain.vo.File;
import ru.esstu.entrant.lk.repositories.FileRepository;

import java.util.List;

@Service
@Slf4j
public class FileService {
    private final FileRepository fileRepository;
    private final FileMapper fileMapper;
    private final AccessService accessService;
    public FileService(FileRepository fileRepository,
                          FileMapper fileMapper,
                          AccessService accessService) {
        this.fileRepository = fileRepository;
        this.fileMapper = fileMapper;
        this.accessService = accessService;
    }
    public List<FileDto> getFiles(final int id) {
        List<FileDto> temp = fileMapper.toDtos(fileRepository.getFiles(id));
        return temp;
    }
    public FileDto save(final String filecode,final String type,final int entrantId,final String fileName,final String fileExtension){
        FileDto fileDto=new FileDto(0,entrantId,fileName,fileExtension,type,filecode);
        File entity=fileMapper.toVO(fileDto);
        fileRepository.save(entity);
        return fileMapper.toDto(entity);
    }
}
