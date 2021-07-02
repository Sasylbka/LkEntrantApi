package ru.esstu.entrant.lk.domain.dto.PublicTables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrantDto {
    private String entrantId;
    private String loginForLk;
    private String passwordForLk;
    private String activateId;
}
