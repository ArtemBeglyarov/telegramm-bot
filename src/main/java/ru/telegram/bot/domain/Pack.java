package ru.telegram.bot.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false,exclude ={"quests","themes"})
@ToString(callSuper = true,exclude ={"quests","themes"})
public class Pack extends Subject{
    @OneToMany(mappedBy = "pack", cascade = CascadeType.ALL)
    private List<Quest> quests;
    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
    private List<Theme> themes;
}
