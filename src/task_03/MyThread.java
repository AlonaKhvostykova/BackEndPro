package task_03;

public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            Main.counter++;
//            Main.counter++; //таким образом обращаемся к , т.к. он находится в другом классе, от кот-го мы наследуемся
        }
    }
}
