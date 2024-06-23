package lesson01_2006.homeWork;

/*
Дан диапазон чисел: от 1 до 2_000_000 включительно.
Задача: найти, сколько чисел из этого диапазона делятся нацело на 21 и при этом содержат цифру 3.
Решить данную задачу в один поток.
Решить данную задачу в два потока, разделив между потоками заданный диапазон чисел.
Сравнить результаты двух решений - они должны совпадать.
 */
public class MainHW1 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i <= 2_000_000; i++) {
            if (i % 21 == 0 && containsDigit3(i)) {
                count++;
            }
        }
        System.out.println("Количество чисел в 1 поток: " + count); // 44611
    }
    private static boolean containsDigit3(int number) {
        String str = Integer.toString(number);
        return str.contains("3");
    }
}
