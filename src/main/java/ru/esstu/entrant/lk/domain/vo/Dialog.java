package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dialog {
    private int Id;
    private String moderatorRole;
    private int entrantId;
    private int lastMessage;
}
