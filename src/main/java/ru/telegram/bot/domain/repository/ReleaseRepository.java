package ru.telegram.bot.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.telegram.bot.domain.Release;

@Repository
public interface ReleaseRepository extends JpaRepository<Release,Long> {
}
