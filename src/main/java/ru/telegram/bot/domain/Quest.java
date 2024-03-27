package ru.telegram.bot.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false,exclude ={"pack","theme"})
@ToString(callSuper = true,exclude ={"pack","theme"})
public class Quest extends Subject {
    private String answer;
    @ManyToOne
    private Pack pack;
    @ManyToOne
    private Theme theme;
}
