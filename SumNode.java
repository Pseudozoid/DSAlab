import java.util.Scanner;
import java.io.*;

class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int d) {
        data = d;
        prev = null;
        next = null;
    }
}

class DList {
    Node first, last;

    public DList() {
        first = last = null;
    }

    public void insertFirst(int item) {
        Node n = new Node(item);
        if(first == null) {
            first = n;
            last = n;
        }

        else {
            n.next = first;
            first.prev = n;
            first = n;
        }
    }
    
    public void insertLast(int item) {
        Node n = new Node(item);
        if(first == null) {
            first = n;
            last = n;
        }
        else {
            last.next = n;
            n.prev = last;
            last = n;
        }
    }

    public void displayForward() {
        Node current = first;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public void sumNodes(int sum) {
        int sumCount = 0;
        for(Node currentFirst = first; currentFirst != null; currentFirst = currentFirst.next) {
            for(Node currentSecond = first; currentSecond != null; currentSecond = currentSecond.next) {
                if(currentFirst.data + currentSecond.data == sum) {
                    System.out.println("(" + currentFirst.data + ", " + currentSecond.data + ")");
                    sumCount++;
                }
            }
        }

        if(sumCount == 0) {
            System.out.println("None of the values give the target sum!");
        }
    }

    public boolean isEmpty() {
        return(first == null);
    }
}

class SumNode {
    public static void main(String args[]) {
        DList list = new DList();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements: ");
        String input = sc.nextLine();

        String[] numbers = input.split(" ");
        
        for(String numString : numbers) {
            int num = Integer.parseInt(numString);

            if(list.isEmpty()) {
                list.insertFirst(num);
            }

            else {
                list.insertLast(num);
            }
        }
        
        System.out.print("Enter target sum: ");
        int sum = sc.nextInt();
        list.sumNodes(sum);
    }
}
