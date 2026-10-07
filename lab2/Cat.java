/*Кот	мяукает.
Создайте	сущность	Кот,	которая	описывается	следующим	образом:
• Имеет	Имя	(строка)
• Для	создания	необходимо	указать	имя	кота.
• Может	быть	приведен	к	текстовой	форме	вида:	“кот:	Имя”
• Может	 помяукать,	 что	 приводит	 к	 выводу	 на	 экран	 следующего	 текста:
“Имя: мяу!”, вызвать мяуканье можно	без	параметров.
• Может	 помяукать	N раз,	 что	 приводит	 к	 выводу	 на	 экран	 следующего	 текста:
,“Имя: мяу мяу-…-мяу!”, где количество	“мяу” равно	N.
Создайте кота по имени	“Барсик”, и	затем пусть	он	помяукает сначала один раз,	а затем	три	раза*/


public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
    }

    public void meow(int n) {
        String result = name + ": ";
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                result = result + "-";
            }
            result = result + "мяу";
        }
        result = result + "!";
        System.out.println(result);
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}