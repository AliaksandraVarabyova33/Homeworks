package tasks;

//Синхронизируйте доступ к переменной через внешний объект.

import java.util.Random;

public class Task9 {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        BankAccount1 bankAccount = new BankAccount1();

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
        Thread walletThread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                int temp = random.nextInt(1, 5);
                bankAccount.addBitcoinToWallet(temp);
            }
        });
        Thread walletThread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                int temp = random.nextInt(1, 5);
                bankAccount.removeBitcoinFromWallet(temp);
            }
        });

        cardThread1.start();
        cardThread2.start();
        walletThread1.start();
        walletThread2.start();

        cardThread1.join();
        cardThread2.join();
        walletThread1.join();
        walletThread2.join();

        bankAccount.showCardBalance();
        bankAccount.showWalletBalance();

    }
}

class BankAccount1 {
    final Object paymentCard = new Object();
    final Object cryptoWallet = new Object();
    int cardBalance;
    int walletBalance;

    public void addMoneyToCard(int sum) {
        synchronized (paymentCard) {
            System.out.println("Current card balance: " + cardBalance + ", adding " + sum);
            cardBalance += sum;
        }
    }

    public void removeMoneyFromCard(int sum) {
        synchronized (paymentCard) {
            System.out.println("Current card balance: " + cardBalance + ", trying to remove: " + sum);
            if (cardBalance >= sum) {
                cardBalance -= sum;
            }
        }
    }

    public void showCardBalance() {
        System.out.println(cardBalance);
    }

    public void addBitcoinToWallet(int sum) {
        synchronized (cryptoWallet) {
            System.out.println("Current wallet balance: " + walletBalance + ", adding " + sum);
            walletBalance += sum;
        }
    }

    public void removeBitcoinFromWallet(int sum) {
        synchronized (cryptoWallet) {
            System.out.println("Current wallet balance: " + walletBalance + ", trying to remove: " + sum);
            if (walletBalance >= sum) {
                walletBalance -= sum;
            }
        }
    }

    public void showWalletBalance() {
        System.out.println(walletBalance);
    }
}

