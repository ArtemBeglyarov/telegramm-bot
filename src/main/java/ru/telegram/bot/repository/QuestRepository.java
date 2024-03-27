package ru.telegram.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.telegram.bot.domain.Quest;

@Repository
public interface QuestRepository  extends JpaRepository<Quest, Long> {
}
