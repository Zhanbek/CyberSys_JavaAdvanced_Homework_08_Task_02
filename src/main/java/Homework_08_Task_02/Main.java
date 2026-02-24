package Homework_08_Task_02;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(() -> {
            try {
                System.out.println("Потік first працює");
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                System.out.println("Перерваний потік first");
            }
        }, "first");

        Thread second = new Thread(() -> {
            try {
                System.out.println("Потік second працює");
                Thread.sleep(4500);
            } catch (InterruptedException e) {
                System.out.println("Перерваний потік second");
            }
        }, "second");

        System.out.println("Потік main працює");
        Thread.sleep(5000);
        first.start();
        second.start();

        // Ждём завершения потоков
        first.join();
        System.out.println("Завершення first");

        second.join();
        System.out.println("Завершення second");

        System.out.println("Завершення main");
    }
}