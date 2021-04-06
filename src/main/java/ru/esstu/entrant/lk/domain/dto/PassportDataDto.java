package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassportDataDto {
    private String id;
    private String serial_number;
    private String place_of_issue;
    private String code_of_subdivision;
    private String date_of_issue;
}