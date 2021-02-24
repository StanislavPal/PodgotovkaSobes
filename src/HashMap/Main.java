package HashMap;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3000];
        HashMap<Animal, String> map = new HashMap<Animal, String>();
        for (int i = 0; i < 5; i++) {
            animals[i] = new Animal(i, "AAA" + i);
            map.put(animals[i], "AAA" + i);
        }

        Animal testAnimal;
        Animal animals1 = animals[1];

        System.out.println("======STEP 1=======");
        System.out.println("Создаем тестовый объект testAnimal с полями как у ключа, но другой по ссылке");
        System.out.println("----------------------------------------------------------------------------");
        testAnimal = new Animal(1, "AAA1");
        System.out.println(testAnimal + " = " + map.get(testAnimal));
        System.out.println(animals1 + " = " + map.get(animals1));
        System.out.println();

        System.out.println("======STEP 2=======");
        System.out.println("Меняем у тестового объекта поля на такие, что такого ключа не будет в мапе");
        System.out.println("----------------------------------------------------------------------------");
        testAnimal = new Animal(20_000, "AAA20000");
        System.out.println(testAnimal + " = " + map.get(testAnimal));
        System.out.println(animals1 + " = " + map.get(animals1));
        System.out.println();

        System.out.println("======STEP 3=======");
        System.out.println("Меняем у объекта, который был ключем, ссылку");
        System.out.println("----------------------------------------------------------------------------");
        animals[1] = new Animal(20_000, "AAA20000");
        System.out.println(testAnimal + " = " + map.get(testAnimal));
        System.out.println(animals1 + " = " + map.get(animals1));
        System.out.println();

        System.out.println("======STEP 4=======");
        System.out.println("А у объекта копии, который был ключем, меняем поля на такие, что такого ключа не будет в мапе");
        System.out.println("----------------------------------------------------------------------------");
        animals1.setId(20_000);
        animals1.setName("AAA20000");
        System.out.println(testAnimal + " = " + map.get(testAnimal));
        System.out.println(animals1 + " = " + map.get(animals1));
        System.out.println();

        System.out.println("======STEP 5=======");
        System.out.println("Продолжаем заполнять мапу, она несколько раз будет ресайзнута");
        System.out.println("----------------------------------------------------------------------------");
        for (int i = 5; i < animals.length; i++) {
            animals[i] = new Animal(i, "AAA" + i);
            map.put(animals[i], "AAA" + i);
            System.out.println(i + ": " + testAnimal + " = " + map.get(testAnimal));
            System.out.println(i + ": " + animals1 + " = " + map.get(animals1));
            System.out.println();
        }

        System.out.println("======STEP 6=======");
        System.out.println("Возвращаем ключу прежние значения полей");
        System.out.println("----------------------------------------------------------------------------");
        animals1.setId(1);
        animals1.setName("AAA1");
        System.out.println(testAnimal + " = " + map.get(testAnimal));
        System.out.println(animals1 + " = " + map.get(animals1));
        System.out.println();
    }
}
