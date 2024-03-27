package ru.telegram.bot.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false,exclude ={"theme","quests"})
@ToString(callSuper = true,exclude ={"theme","quests"})
public class Theme extends Subject {

    @OneToMany(mappedBy = "pack", cascade = CascadeType.ALL)
    private List<Quest> quests;
    @ManyToOne
    private Pack theme;
}
