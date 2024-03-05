package ru.telegram.bot.domain;

import lombok.Data;
import ru.telegram.bot.domain.enums.Label;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public abstract class Subject {
    @Id
    private Long id;
    @OneToMany
    private List<Quest> quests;
    private List<Label> labels;
 }
