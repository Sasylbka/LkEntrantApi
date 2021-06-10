package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {
    private int id;
    private int entrantId;
    private String fileName;
    private String fileExtension;
    private String documentType;
    private String guid;
}
