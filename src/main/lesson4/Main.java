import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        reverseWords("first second third");
        runASCIITransformer();
    }

    //Task1: Напишите программу, которая принимает строку и переставляет слова в обратном порядке

    /*метод переворачивает строку только с пробелами (не обрабатываются знаки препинания)
    более простая реализация с использование List не написана сознательно в целях эксперимента :-)*/
    public static void reverseWords(String str) {
        StringBuilder word = new StringBuilder();
        StringBuilder sentence = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {   //идем по строке, начиная с конца
            if (str.charAt(i) != ' ') {
                word.append(str.charAt(i));             //пока не встретим пробел собираем символы в первый стрингбилдер
            } else {                                    //если пришел пробел
                word.reverse();                         //переворачиваем символы, чтобы получить слово
                word.append(str.charAt(i));             //добавляем в конец слова пробел
                sentence.append(word);                  //добавляем слово во второй стрингбилдер
                word.delete(0, word.length());          //очищаем первый стрингбилдер, чтобы собрать след. слово
            }
        }
        word.reverse();            //при считывании последнего слова пробела не будет, поэтому финальный раз переворачиваем символы
        sentence.append(word);     // добавляем последнее слово
        System.out.println(sentence);
    }

    //Task2: Реализуйте программу, которая преобразует строку в последовательность ASCII-кодов и строку кодов в текст
    public static void changeStringToASCII(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append((int) str.charAt(i));
            sb.append(' ');
        }
        System.out.println(sb);
    }

    public static void changeASCIIToString(String str) {
        StringBuilder sb = new StringBuilder();
        String[] symbols = str.split(" ");
        for (String symbol : symbols) {
            sb.append((char) (Integer.parseInt(symbol)));
        }
        System.out.println(sb);

    }

    public static void runASCIITransformer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter '1' to enter ASCII symbols ot '2' to enter string");
        int i = sc.nextInt();
        sc.nextLine();//проглатываем символ новой строки после нажатия на enter
        if (i == 1) {
            System.out.println("Enter ASCII symbols, use space as delimeter");
            changeASCIIToString(sc.nextLine());
        } else {
            System.out.println("Enter string");
            changeStringToASCII(sc.nextLine());
        }
    }
}
