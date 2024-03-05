package ru.telegram.bot.domain;

import lombok.Data;
import ru.telegram.bot.domain.enums.Label;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Quest {
    @Id
    private Long id;
    private String quest;
    private Label label;
}
