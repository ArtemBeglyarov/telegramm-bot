package ru.telegram.bot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Release {

    @Id
    private Long id;
    @OneToMany
    private Set<Task> tasks;
    @OneToMany
    private Set<Bug> bugs;
    LocalDateTime releaseDate;
}
