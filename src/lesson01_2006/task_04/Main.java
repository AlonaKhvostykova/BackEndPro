package lesson01_2006.task_04;
//есть целочисл-й счетчик.
//Есть 3 потока. Каждый поток в цикле должен увеличить миллион раз значение счетчика на единицу
//и вывести значение счетчика в консоль, т.е. счетчик д.б. = 3_000_000

public class Main {

    private static  int counter;

    public static void increment(){
        counter++;
    }

    public static synchronized void main(String[] args) {

        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.start();
        myThread2.start();

        for (int i = 0; i < 1_000_000; i++) {
            increment();
        }

        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter value: " + counter);
    }
}
