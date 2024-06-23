package lesson01_2006.task_01;

public class Main {
    public static void main(String[] args) {

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        //Cтарт отдельного потока при 1-м способе
        myThread1.start();
//        myThread2.run();

        //Старт отдельного потока при 2-м способе
        Thread thread = new Thread(myThread2);

        //сделали из потока демон-поток с пом. м-да .setDaemon(true)
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 10; i++) {

            //Способы создания потоков:
            //1. Наследуемся от класса Thread
            //2. Реализуем интерфейс Runnable

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
