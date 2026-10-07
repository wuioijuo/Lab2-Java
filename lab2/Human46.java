/*
$4.6 Создаем	Человека.	Измените	сущность	Человек	из	задачи	2.3.	Новые	требования	включают:
• Человека	можно	 создать	 с	 указанием	 имени	 в	 виде	 строки	 и	 роста	 в	 виде	 целого	 числа.	
При	таком	способе	задания	имени	должно	считаться,	что	Человеку	задано	только	личное	
имя.
• Человека	можно	 создать	 с	 указанием	 имени	 в	 виде	 строки,	 роста	 в	 виде	 целого	 числа	 и	
отца	 в	 виде	 Человека.	 В	 этом	 случае	 необходимо	 проставить	 отчество	 в	 соответствии	 с	
именем	отца	и	присвоить	текущему	человеку	фамилию	отца.
• Человека	 можно	 создать	 с	 указанием	 имени	 в	 виде	 объекта	 типа	 Имя	 (из	 задачи	 4.5)	 и	
роста	в	виде	целого	числа.	
• Человека	 можно	 создать	 с	 указанием	 имени	 в	 виде	 объекта	 типа	 Имя	 (из	 задачи	 4.5),	
роста	 в	 виде	 целого	 числаи	 отца	 в	 виде	 Человека.	 В	 этом	 случае	 необходимо	 проверить	
что	в	Имени	задано	отчество	и	фамилия,	и	если	они	не	заданы,	то	необходимо	их	задать	
(отчество	в	соответствии	с	именем	отца	и	фамилию	отца).
• Реализуйте	 описанные	 способы	 создания	 Человека	 таким	 образом,	 чтобы	 операции	
присвоения	использовались	только	в	одном	из	конструкторов.	
• Необходимо	 модифицировать	 способ	 приведения	 Человека	 к	 строке,	 теперь	 текстовая	
форма	должна	быть	представлена	строкой:	“Имя,	рост”
Создайте	и	выведите	на	экран	следующие	объекты:
1. Человека	с	именем	Лев	(в	виде	строки)	и	ростом	170
2. Человека	с	именем	Пушкин	Сергей	(как	Имя),	ростом	168	и	отцом	Львом	(предыдущий	Человек)
3. Человека	 с	 именем	 Александр	 (в	 виде	 строки),	 ростом	 167	 и	 отцом	 Сергеем	 (предыдущий	
Человек)*/


public class Human46 {
    private Name45 name;
    private int height;
    private Human46 father;

    // ГЛАВНЫЙ конструктор — здесь ЕДИНСТВЕННОЕ присвоение
    public Human46(Name45 name, int height, Human46 father) {
        this.name = name;
        this.height = height;
        this.father = father;
    }

    // Конструктор 1: имя строкой + рост → вызывает главный
    public Human46(String firstName, int height) {
        this(new Name45(firstName), height, null);
    }

    // Конструктор 2: имя строкой + рост + отец → вызывает главный
    public Human46(String firstName, int height, Human46 father) {
        this(new Name45(firstName), height, father);
    }

    // Конструктор 3: имя объектом + рост → вызывает главный
    public Human46(Name45 name, int height) {
        this(name, height, null);
    }

    @Override
    public String toString() {
        String surname = name.getSurname();
        String patronymic = name.getPatronymic();

        if (father != null) {
            if (surname == null && father.name.getSurname() != null) {
                surname = father.name.getSurname();
            }
            if (patronymic == null && father.name.getFirstName() != null) {
                patronymic = makePatronymic(father.name.getFirstName());
            }
        }

        String result = "";
        if (surname != null) result = result + surname;
        if (name.getFirstName() != null) {
            if (result.length() > 0) result = result + " ";
            result = result + name.getFirstName();
        }
        if (patronymic != null) {
            if (result.length() > 0) result = result + " ";
            result = result + patronymic;
        }

        return result + ", рост: " + height;
    }

    private String makePatronymic(String fatherName) {
        if (fatherName.equals("Лев")) return "Львович";
        if (fatherName.equals("Павел")) return "Павлович";
        if (fatherName.equals("Яков")) return "Яковлевич";

        char last = fatherName.charAt(fatherName.length() - 1);
        if (last == 'й' || last == 'ь') {
            return fatherName.substring(0, fatherName.length() - 1) + "евич";
        }
        if (last == 'а' || last == 'я') {
            return fatherName.substring(0, fatherName.length() - 1) + "ич";
        }
        return fatherName + "ович";
    }
}

