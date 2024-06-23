package lesson01_2006.task_02;
//есть целочисл-й счетчик.
//В цикле необходимо увеличить значение счетчика 1000000 раз на единицу. Вывести значение счетчика в консоль

public class Main {

    public static  int counter;

    public static void main(String[] args) {

        for (int i = 0; i < 1_000_000; i++) {
            counter++;
        }
        System.out.println("Counter value: " + counter); //Counter value: 1000000 -кол-во итерация
    }
}
