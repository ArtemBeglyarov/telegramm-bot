package ru.telegram.bot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
@Getter
@Setter
public class Task {

    @Id
    private String link;
    private Staus statusTask;
    private Long saTime;
    private Long devTime;
    private Long qaTime;
    @ManyToOne
    private Release release;
}
