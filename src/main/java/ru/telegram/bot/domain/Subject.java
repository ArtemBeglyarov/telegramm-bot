package ru.telegram.bot.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public abstract class Subject {
    @Id
    @GeneratedValue()
    private Long id;
    private String name;
 }
