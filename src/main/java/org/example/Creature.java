package org.example;

import java.util.Random;

/**
 * Представляет существо с атакой, защитой и здоровьем.
 */
public class Creature {
    private final int attack;
    private final int defence;
    private int health;
    private final int[] damage = {1, 2, 3, 4, 5, 6};

    /**
     * Конструктор Creature со случайными значениями атаки и защиты, и начальным здоровьем 100.
     */
    public Creature() {
        this.attack = new Random().nextInt(30) + 1;
        this.defence = new Random().nextInt(30) + 1;
        this.health = 100;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return health;
    }

    void setHealth(int health) {
        this.health = health;
    }

    /**
     * Выполняет атаку существа на защищающееся существо.
     *
     * @param defending Защищающееся существо.
     * @return Значение нанесенного урона.
     */
    public int makeHit(Creature defending) {
        int value = 0;
        int modifier = attack - (defending.getDefence() + 1);
        if (modifier <= 1) {
            int rollResult = new Random().nextInt(6) + 1;
            if (rollResult >= 5) {
                value = damage[new Random().nextInt(damage.length)];
                defending.setHealth(defending.getHealth() - value);
            }
        } else {
            boolean isLuck = false;
            for (int i = 0; i < modifier; i++) {
                int rollResult = new Random().nextInt(6) + 1;
                if (rollResult >= 5) {
                    isLuck = true;
                }
            }
            if (isLuck) {
                value = damage[new Random().nextInt(damage.length)];
                defending.setHealth(defending.getHealth() - value);
            }
        }
        return value;
    }
}
