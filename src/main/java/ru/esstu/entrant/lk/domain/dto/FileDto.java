package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {
private int id;
private int entrantId;
private String fileName;
private String fileExtension;
private String documentType;
private String guid;
}
