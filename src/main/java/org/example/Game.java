package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Представляет игру, в которой игроку нужно сразиться с несколькими монстрами.
 */
public class Game {
    Scanner sc = new Scanner(System.in);
    Player player;
    Monster monster;
    int monstersCount = 0;
    int healsCount = 0;

    /**
     * Создает игрока, запрашивая у пользователя его игровое имя.
     */
    private void CreatePlayer() {
        System.out.println("Для создания персонажа придумайте ему игровое имя: ");
        player = new Player(sc.nextLine());
        System.out.println("Поздравляю! Вы создали персонажа \"" + player.getName() + "\", его характеристики:");
        System.out.println("Здоровье: " + player.getHealth());
        System.out.println("Защита: " + player.getDefence());
        System.out.println("Атака: " + player.getAttack());
        System.out.println("Ваша задача стать богом рандома и победить 3-х монстров! У вас есть возможность  4 раза " +
                "восстановить себе 30% от максимального здоровья для победы над жуткими тварями.");
    }

    /**
     * Создает нового монстра.
     */
    private void CreateMonster() {
        monster = new Monster();
        monstersCount++;
        System.out.println("Ваш новый враг \"" + monster.getName() + "\", его характеристики:");
        System.out.println("Здоровье: " + monster.getHealth());
        System.out.println("Защита: " + monster.getDefence());
        System.out.println("Атака: " + monster.getAttack());
    }

    /**
     * Восстанавливает здоровье игрока.
     */
    private void heal() {
        if (healsCount < 4) {
            healsCount++;
            player.getHeal();
            System.out.println("Ваше здоровье теперь: " + player.getHealth());
        } else System.out.println("Вы восстановили свое здоровье максимальное количество раз!");
    }

    /**
     * Выполняет атаку игрока на монстра и атаку монстра на игрока.
     *
     * @param player  Игрок.
     * @param monster Монстр.
     */
    private void attack(Player player, Monster monster) {
        int val = player.makeHit(monster);
        System.out.println("Вы атаковали монстра и нанесли ему " + val + " урона!");
        System.out.println("Здоровье монстра теперь: " + monster.getHealth());
        int val2 = monster.makeHit(player);
        System.out.println("Монстр атаковал вас в ответ и нанес вам " + val2 + " урона!");
        System.out.println("Ваше здоровье теперь: " + player.getHealth());
    }

    /**
     * Отображает список доступных действий для игрока.
     */
    private void writeNextAction() {
        System.out.println("Выберите действие:");
        System.out.println("1. Атаковать");
        System.out.println("2. Лечиться");
        System.out.println("3. Выход из игры");
    }

    /**
     * Запускает игру.
     */
    public void start() {
        CreatePlayer();
        while (monstersCount < 3 && player.getHealth() > 0) {
            CreateMonster();
            while (monster.getHealth() > 0 && player.getHealth() > 0) {
                writeNextAction();
                try {
                    int num = sc.nextInt();
                    switch (num) {
                        case 1 -> attack(player, monster);
                        case 2 -> heal();
                        case 3 -> {
                            System.out.println("До встречи!");
                            System.exit(0);
                        }
                        default -> System.out.println("Такого действия нет. Выберите верное дествие.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка! Введите число \"1\", \"2\", либо \"3\".");
                    sc.next();
                }
            }
            if (monster.getHealth() < 0) {
                System.out.println("Ура, вы победили монстра! Но это еще не все, осталось монстров: " + (3 - monstersCount));
            }
        }
        if (monstersCount != 3) {
            System.out.println("О нет! Вы проиграли! Рандом сегодня не на вашей стороне :((");
            System.out.println("Выберите действие: ");
        } else {
            System.out.println("Ура, вы победили всех монстров! Вы настоящий бог рандома!");
            System.out.println("Выберите действие: ");
        }
    }
}
