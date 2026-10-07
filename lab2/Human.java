/*
№2.2 Человек	с	именем.	
Объедините	 сущности	 Человек	 из	 задачи	 1.2 и	 Имя	 из	 задачи	 1.3 таким	 образом,	 чтобы	 имя	
человека	задавалось	с	использованием	сущности	1.3,	а	не	строки.	
Необходимо	объединить	ранее	созданные	объекты	имен	и	людей,	с	получением:
• Человека	с	Именем	Клеопатра	и	ростом	152
• Человека	с	Именем	Пушкин	Александр	Сергеевичи	ростом	167
• Человека	с	Именем	Маяковский	Владимир	и	ростом	189

№2.3 Человек	с	родителем.	
Измените	сущность	Человек	из	задачи	2.2 добавив	ему	 возможность	задавать	 третий	параметр:	
Отец,	 где	 Отец	— это	 тоже	 Человек.	При	 приведении	 человека	 к	 строковой	 форме	 необходимо	
проверить	 параметры	 имени,	 и	 в	 зависимости	 от	 ситуации	 выполнить	 одно	 из	 следующих	
действий:
• Если	 у	 данного	 человека	 нет	 фамилии,	 и	 есть	 отец,	 у	 которого	 фамилия	 задана,	 то	
фамилию	необходимо	сделать	такой	же	как	у	отца.
• Если	у	данного	человека	нет	отчества,	а	у	отца	есть	имя,	то	необходимо	задать	отчество	
как	имя	отца	с	добавлением	суффикса	“ович”.	
Затем	необходимо	выполнить	следующие	задачи:
1. Создать	людей:	Чудова	Ивана,	Чудова	Петра,	Бориса
2. Сделать	Ивана	отцом	Петра,	а	Петра	отцом	Бориса
3. Вывести	на	экран	строковое	представление	всех	троих	людей.
При желании	 можно	 попытаться	 реализовать	 систему	 в	 более	 полном	 виде:	 предусмотреть	
разные	 виды	 суффиксов	 отчества	 в	 зависимости	 от	 окончания	 имени,	 а	 также	 предусмотреть	
возможность	задавать	пол человека и менять суффикс отчества в зависимости от пола.*/


public class Human {
    private Name name;
    private int height;
    private Human father;

    public Human(Name name, int height) {
        this.name = name;
        this.height = height;
    }

    public Human(Name name, int height, Human father) {
        this.name = name;
        this.height = height;
        this.father = father;
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

        if (surname != null) {
            result = result + surname;
        }
        if (name.getFirstName() != null) {
            if (result.length() > 0) {
                result = result + " ";
            }
            result = result + name.getFirstName();
        }
        if (patronymic != null) {
            if (result.length() > 0) {
                result = result + " ";
            }
            result = result + patronymic;
        }

        return result + ", рост: " + height;
    }

    private String makePatronymic(String fatherName) {
        if (fatherName.equals("Лев")) {
            return "Львович";
        }
        if (fatherName.equals("Павел")) {
            return "Павлович";
        }
        if (fatherName.equals("Яков")) {
            return "Яковлевич";
        }

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