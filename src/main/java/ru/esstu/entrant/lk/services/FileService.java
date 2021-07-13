package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.FileDto;
import ru.esstu.entrant.lk.domain.mappers.FileMapper;
import ru.esstu.entrant.lk.domain.vo.EntrantPrivateData;
import ru.esstu.entrant.lk.domain.vo.File;
import ru.esstu.entrant.lk.domain.vo.Message;
import ru.esstu.entrant.lk.repositories.EntrantPrivateDataRepository;
import ru.esstu.entrant.lk.repositories.FileRepository;
import ru.esstu.entrant.lk.repositories.MessageRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class FileService {
    private final FileRepository fileRepository;
    private final FileMapper fileMapper;
    private final AccessService accessService;
    private final EntrantPrivateDataRepository entrantPrivateDataRepository;
    private final MessageRepository messageRepository;
    public FileService(FileRepository fileRepository,
                       FileMapper fileMapper,
                       AccessService accessService, EntrantPrivateDataRepository entrantPrivateDataRepository, MessageRepository messageRepository) {
        this.fileRepository = fileRepository;
        this.fileMapper = fileMapper;
        this.accessService = accessService;
        this.entrantPrivateDataRepository = entrantPrivateDataRepository;
        this.messageRepository = messageRepository;
    }
    public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }
    public List<FileDto> getFiles(final int id) {
        accessService.commonAccessCheck(id);
        List<FileDto> temp = fileMapper.toDtos(fileRepository.getFiles(id));
        return temp;
    }
    public FileDto save(final String filecode,final String type,final int entrantId,final String fileName,final String fileExtension){
        FileDto fileDto=new FileDto(0,entrantId,fileName,fileExtension,type,filecode);
        File entity=fileMapper.toVO(fileDto);
        fileRepository.save(entity);
        return fileMapper.toDto(entity);
    }
    public void saveInMessage(final String filecode,
                                 final String type,final int entrantId,final String fileName,
                                 final String fileExtension,final int dialogId,final String role,final String sendedMessage,
                                 final String filename){
        FileDto fileDto=new FileDto(0,entrantId,fileName,fileExtension,type,filecode);
        File entity=fileMapper.toVO(fileDto);
        fileRepository.save(entity);
        EntrantPrivateData entrantPrivateData = entrantPrivateDataRepository.getEntrantPrivateData(entrantId);
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = convertToDateViaSqlTimestamp(localDateTime);
        Message message = new Message(0,role,dialogId,entrantId,entrantPrivateData.getName()+" "+entrantPrivateData.getFamilyName()+" "+
                entrantPrivateData.getPatronymic(),sendedMessage,date,true,filecode,filename);
        messageRepository.saveAttachments(message);
        fileMapper.toDto(entity);
    }
    public void delete(final int idForDelete){
        fileRepository.delete(idForDelete);
    }
}
