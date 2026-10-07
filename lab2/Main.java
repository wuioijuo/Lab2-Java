public class Main {
    public static void main(String[] args) {
        System.out.println("Лабораторная работа №2. Вариант 3");


        // ========== Задание 1.3: Имена ==========
        System.out.println();
        System.out.println("--- Задание 1.3: Имена ---");

        Name n1 = new Name(null, "Клеопатра", null);
        Name n2 = new Name("Пушкин", "Александр", "Сергеевич");
        Name n3 = new Name("Маяковский", "Владимир", null);   

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);


        // ========== Задание 2.2: Человек с именем ==========
        System.out.println();
        System.out.println("--- Задание 2.2: Человек с именем ---");

        Human cleopatra = new Human(n1, 152);
        Human pushkin = new Human(n2, 167);
        Human mayakovsky = new Human(n3, 189);

        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(mayakovsky);


        // ========== Задание 2.3: Человек с родителем ==========
        System.out.println();
        System.out.println("--- Задание 2.3: Человек с родителем ---");

        Human ivan = new Human(new Name("Чудов", "Иван", null), 180);
        Human petr = new Human(new Name(null, "Петр", null), 175, ivan);
        Human boris = new Human(new Name(null, "Борис", null), 170, petr);

        System.out.println(ivan);
        System.out.println(petr);
        System.out.println(boris);


        // ========== Задание 3.3: Города ==========
        System.out.println();
        System.out.println("--- Задание 3.3: Города ---");

        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City("F");


        // --- Двусторонние дороги ---
        a.addTwoWayRoad(b, 5);
        a.addTwoWayRoad(d, 6);
        f.addTwoWayRoad(e, 2);
        b.addTwoWayRoad(c, 3);
        c.addTwoWayRoad(d, 4);


        // --- Односторонние дороги ---
        a.addRoad(f, 1);
        f.addRoad(b, 1);
        d.addRoad(e, 2);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);


        // ========== Задание 4.5: Создаем Имена ==========
        System.out.println();
        System.out.println("--- Задание 4.5: Создаем Имена ---");

        Name45 name1 = new Name45("Клеопатра");
        Name45 name2 = new Name45("Александр", "Сергеевич", "Пушкин");
        Name45 name3 = new Name45("Владимир", "Маяковский");
        Name45 name4 = new Name45("Христофор", "Бонифатьевич");

        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);


        // ========== Задание 4.6: Создаем Человека ==========
        System.out.println();
        System.out.println("--- Задание 4.6: Создаем Человека ---");

        Human46 lev = new Human46("Лев", 170);
        Human46 sergey = new Human46(new Name45("Сергей", "Пушкин"), 168, lev);
        Human46 alexander = new Human46("Александр", 167, sergey);

        System.out.println(lev);
        System.out.println(sergey);
        System.out.println(alexander);


        // ========== Задание 5.2: Кот мяукает ==========
        System.out.println();
        System.out.println("--- Задание 5.2: Кот мяукает ---");

        Cat cat = new Cat("Барсик");
        System.out.println(cat);
        cat.meow();
        cat.meow(3);
    }
}