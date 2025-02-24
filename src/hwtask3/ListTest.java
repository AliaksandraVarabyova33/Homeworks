package hwtask3;

public class ListTest {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addElement(5);
        list.addElement(7);
        list.addElement(3);
        list.addElement(15);
        list.addElement(1);

        list.showList();

        System.out.println(list.findElementByValue(9)); //false
        System.out.println(list.findElementByValue(7)); //true

        list.removeElementByValue(5);
        list.showList(); //[7] [3] [15] [1]

        list.removeElementByValue(2);
        list.showList(); //[7] [3] [15] [1] : nothing changes - element 2 is not in the list

        list.removeElementByValue(3);
        list.showList(); //[7] [15] [1]

        list.removeElementByValue(1);
        list.showList(); //[7] [15]
    }
}
