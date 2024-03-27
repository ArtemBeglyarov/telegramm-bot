package ru.telegram.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.telegram.bot.domain.Theme;

@Repository
public interface ThemeRepository  extends JpaRepository<Theme, Long> {
}
