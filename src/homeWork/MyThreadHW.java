package homeWork;

public class MyThreadHW extends Thread {
    @Override
    public void run() {

        for (int i = 1_000_001; i <= 2_000_000; i++) {
            if (i % 21 == 0 && containsDigit3(i)) {
                MainHW2.increment();
            }
        }
    }

    private static boolean containsDigit3(int number) {
        String str = Integer.toString(number);
        return str.contains("3");
    }

}
