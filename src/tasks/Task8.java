package tasks;

//Используйте ключевое слово synchronized для синхронизации нескольких методов класса.

import java.util.Random;

public class Task8 {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        BankAccount bankAccount = new BankAccount();

        Thread cardThread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                int temp = random.nextInt(1, 1000);
                bankAccount.addMoneyToCard(temp);
            }
        });
        Thread cardThread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                int temp = random.nextInt(1, 1000);
                bankAccount.removeMoneyFromCard(temp);
            }
        });

        cardThread1.start();
        cardThread2.start();


        cardThread1.join();
        cardThread2.join();


        bankAccount.showCardBalance();


    }
}

class BankAccount {

    int cardBalance;

    public synchronized void addMoneyToCard(int sum) {
        System.out.println("Current card balance: " + cardBalance + ", adding " + sum);
        cardBalance += sum;
    }

    public synchronized void removeMoneyFromCard(int sum) {
        System.out.println("Current card balance: " + cardBalance + ", trying to remove: " + sum);
        if (cardBalance >= sum) {
            cardBalance -= sum;
        }
    }

    public void showCardBalance() {
        System.out.println(cardBalance);
    }

}

