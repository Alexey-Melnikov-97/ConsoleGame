package org.example;

/**
 * Класс Player унаследован от класса Creature и представляет существо игрока в игре.
 */
public class Player extends Creature {
    private String name;

    /**
     * Конструктор класса Player.
     *
     * @param name имя игрока
     */
    public Player(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Метод для восстановления здоровья игрока.
     * Увеличивает текущее здоровье игрока на 30.
     */
    public void getHeal() {
        setHealth(getHealth() + 30);
    }
}
