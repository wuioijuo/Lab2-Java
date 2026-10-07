/*Города.
Создайте	 сущность	 Город,	 которая	 будет	 представлять	 собой	 точку	 на	 карте	 со	 следующими	
характеристиками:
• Название	города
• Набор	 путей	 к	 следующим	 городам,	 где	 путь	 представляет	 собой	 сочетание	 Города	 и	
стоимости	поездки	в	него.
Кроме	того,	Город	может	возвращать	текстовое	представление,	в	виде	названия	города	и	списка	
связанных	с	ним	городов	(в	виде	пары:	“название:стоимость”).
Используя	разработанную	сущность	реализуйте	схему,	представленную	на	рисунке	2.*/


import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<Road> roads;

    public City(String name) {
        this.name = name;
        this.roads = new ArrayList<Road>();
    }

    // Односторонняя дорога
    public void addRoad(City city, int cost) {
        roads.add(new Road(city, cost));
    }

    // Двусторонняя дорога
    public void addTwoWayRoad(City city, int cost) {
        this.addRoad(city, cost);
        city.addRoad(this, cost);
    }

    @Override
    public String toString() {
        String result = name + ": ";
        for (int i = 0; i < roads.size(); i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + roads.get(i).toString();
        }
        return result;
    }

    private static class Road {
        City city;
        int cost;

        Road(City city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return city.name + ":" + cost;
        }
    }
}




/*public class City {
    private String name;
    private Road[] roads;   // массив дорог
    private int count;      // сколько дорог реально добавлено

    public City(String name) {
        this.name = name;
        this.roads = new Road[20];   // максимум 20 дорог (с запасом)
        this.count = 0;
    }

    // Односторонняя дорога
    public void addRoad(City city, int cost) {
        roads[count] = new Road(city, cost);
        count = count + 1;
    }

    // Двусторонняя дорога
    public void addTwoWayRoad(City city, int cost) {
        this.addRoad(city, cost);   // добавляем в эту сторону
        city.addRoad(this, cost);   // и в обратную
    }

    @Override
    public String toString() {
        String result = name + ": ";
        for (int i = 0; i < count; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + roads[i].toString();
        }
        return result;
    }

    // Вспомогательный класс «дорога»
    private static class Road {
        City city;   // куда ведёт
        int cost;    // стоимость

        Road(City city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return city.name + ":" + cost;
        }
    }
} */