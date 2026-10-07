/*
№1.3 Имена.	
Создайте сущность Имя, которая описывается тремя параметрами: 
Фамилия,Личное имя,Отчество.
Имя	может быть приведено к строковому виду, включающему традиционное представление всех трех параметров: 
Фамилия Имя Отчество (например “Иванов Иван	Иванович”).	
Необходимо	предусмотреть	возможность	того,	что	какой-либо	из	параметров	может	
быть не	задан, и в это случае он не	учитывается	при	приведении	к	текстовому	виду.
Необходимо создать следующие имена:
• Клеопатра
• Пушкин Александр Сергеевич
• Маяковский Владимир
Обратите внимание, что при выводе на экран, не заданные параметры никак не участвуют в образовании строки.*/


public class Name {

    private String surname;
    private String firstName;
    private String patronymic;

    //ФИО
    public Name(String surname, String firstName, String patronymic) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public String getSurname() { return surname; }
    public String getFirstName() { return firstName; }
    public String getPatronymic() { return patronymic; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    @Override
    public String toString() {
        String result = "";

        if (surname != null) {
            result = result + surname;
        }
        if (firstName != null) {
            if (result.length() > 0) result = result + " ";
            result = result + firstName;
        }
        if (patronymic != null) {
            if (result.length() > 0) result = result + " ";
            result = result + patronymic;
        }

        return result;
    }
}