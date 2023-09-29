package org.example;

import java.util.Random;

/**
 * Класс Monster унаследован от класса Creature и представляет существо монстра в игре.
 */
public class Monster extends Creature {
    private final String name;

    /**
     * Конструктор класса Monster.
     * Инициализирует объект монстра и генерирует его имя.
     */
    public Monster() {
        super();
        this.name = generateName();
    }

    public String getName() {
        return name;
    }

    /**
     * Вспомогательный метод для генерации имени монстра.
     *
     * @return сгенерированное имя монстра
     */
    private String generateName() {
        String[] adjectives = {"big", "small", "fast", "slow", "happy", "sad", "beautiful", "ugly", "smart", "dumb"};
        String[] nouns = {"head", "neck", "leg", "arm", "hand", "foot", "eye", "mouth", "ear", "nose"};
        int indexOne = new Random().nextInt(adjectives.length);
        int indexTwo = new Random().nextInt(nouns.length);
        return adjectives[indexOne] + nouns[indexTwo];
    }
}
