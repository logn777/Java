package com.company;

public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
        String[] wordListOne = {"кпуглосуточный", "трех-звенный",
                "30000-футовый", "взаимный", "обоюдный выигрыш", "фронтэнд",
                "на основе веб-технологий", "прокающий", "умный", "шесть сигм",
                "метод критического пути", "динамичный"};
        String[] wordListTwo = {"уполномоченный", "трудный",
                "чистый продукт", "ориентированный", "центральный",
                "распередёленный", "кластеризованный", "фирменный",
                "нестандартный ум", "позиционированный", "сетевой",
                "сфокусированный", "использованный с выгодой", "выровненный",
                "нацеленный на", "общий", "совместный", "ускоренный"};
        String[] wordListThree = {"процесс", "пункт разгрузки",
                "выход из положения", "тип структуры", "талант", "подход",
                "уровень завоеванного внимания", "портал", "период времени",
                "обзор", "образец", "пунк следования"};

        int oneLen = wordListOne.length;
        int twoLen = wordListTwo.length;
        int threeLen = wordListThree.length;

        int rand1 = (int)(Math.random() * oneLen);
        int rand2 = (int)(Math.random() * twoLen);
        int rand3 = (int)(Math.random() * threeLen);

        String Phrase = wordListOne[rand1] + " " +
                wordListTwo[rand2] + " " + wordListThree[rand3];

        System.out.println("Все что нам нужно - это" + " " + Phrase);
    }
}
