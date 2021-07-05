package ru.esstu.entrant.lk.domain.vo.PublicTables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrantForKeycloak {
    private String entrantId;
    private String loginForLk;
    private String passwordForLk;
    private String activateId;
}
