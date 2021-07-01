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
    private int lastMessage;//id последнего сообщения
    private int lastReadEntrantMessage;//id последнего прочитанного сообщения энтрантом
    private int lastReadModeratorMessage;//id последнего прочитанного сообщения не-entrant
    private boolean haveUnreadEntrantMessage;//Непрочитанные сообщения у энтранта
    private boolean haveUnreadModeratorMessage;//Непрочитанные сообщения у модератора
}
