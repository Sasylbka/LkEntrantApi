package ru.esstu.entrant.lk.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationDto {//Константы
    private int id;
    private int maxWithdrawalOfConsent;//Максимальное количество отзывов согласия
    private Date lastDateBudget;//Последняя дата подачи согласия на бюджет.
    private Date lastDateQuote;//Последняя дата подачи согласия по особым правам.
}
