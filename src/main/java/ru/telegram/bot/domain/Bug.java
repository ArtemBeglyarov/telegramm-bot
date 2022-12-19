package ru.telegram.bot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Bug {

    @Id
    private String link;
    @ManyToOne
    private Release release;
}
