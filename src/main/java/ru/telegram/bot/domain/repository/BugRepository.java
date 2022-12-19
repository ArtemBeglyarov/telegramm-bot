package ru.telegram.bot.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.telegram.bot.domain.Bug;

@Repository
public interface BugRepository extends JpaRepository<Bug,String> {
}
