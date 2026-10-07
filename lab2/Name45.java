/*
№4.5 Создаем	Имена.	
Измените	сущность	Имя	из	задачи	1.3.	Новые	требования	включают:
• Имя	можно	создать	указав	только	Личное	имя
• Имя	можно	создать	указав	 Личное	имя и	Фамилию.
• Имя	можно	создать	указав	все	три	параметра:	Личное	имя,	Фамилию,	Отчество.
Необходимо	создать	следующие	имена:
1. Клеопатра
2. Александр	Сергеевич	Пушкин
3. Владимир	Маяковский
4. Христофор	Бонифатьевич	(здесь	Христофор	это	имя,	а	Бонифатьевич	- фамилия)*/


public class Name45 {
    private String firstName;
    private String patronymic;
    private String surname;

    //только личное имя
    public Name45(String firstName) {
        this.firstName = firstName;
    }

    //личное имя и фамилия
    public Name45(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    //личное имя, отчество, фамилия
    public Name45(String firstName, String patronymic, String surname) {
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.surname = surname;
    }

    public String getSurname() { return surname; }
    public String getFirstName() { return firstName; }
    public String getPatronymic() { return patronymic; }

    @Override
    public String toString() {
        String result = "";
        if (firstName != null) {
            result = result + firstName;
        }
        if (patronymic != null) {
            if (result.length() > 0) result = result + " ";
            result = result + patronymic;
        }
        if (surname != null) {
            if (result.length() > 0) result = result + " ";
            result = result + surname;
        }
        return result;
    }
}
