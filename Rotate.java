import java.util.*;
import java.io.*;

class Node {
    public char data;
    public Node next;
    public Node prev;

    public Node(char d) {
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

    public void insertFirst(char item) {
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
    
    public void insertLast(char item) {
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

    public void rotateList(int n) {
        Node current = first;
        for(int i = 1; i < n; i++) {
            current = current.next;
        }

        last.next = first;
        first.prev = last;
        first = current.next;
        first.prev = null;
        current.next = null;
    }

    public boolean isEmpty() {
        return(first == null);
    }
}

class Rotate {
    public static void main(String args[]) {
        DList list = new DList();
        System.out.println("Enter the string: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        for(char ch : input.toCharArray()) {
            if(list.isEmpty()) {
                list.insertFirst(ch);
            }

            else {
                list.insertLast(ch);
            }
        }

        System.out.println("Enter n: ");
        int n = sc.nextInt();

        if(n > input.length()) {
            System.out.println("Invalid Input!");
        }

        else {
            list.rotateList(n);
            list.displayForward();
            System.out.print("\n");
        }
    }   
}
