package ru.telegram.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.telegram.bot.domain.Pack;

@Repository
public interface PackRepository extends JpaRepository<Pack, Long> {
}
