/**
 * @ClassName Delink
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2519:10
 * @Version 1.0
 */

public class Delink {
    public static class Node {
        int data;
        Node pre, next;
    }

    private static Node create(int[] data) {
        if (data == null || data.length == 0) {
            return null;
        }

        Node head = null;
        Node p = null;
        for (int i = 0; i < data.length; i++) {
            Node node = new Node();
            node.data = data[i];
            node.pre = null;
            node.next = null;
            if (head == null) {
                head = node;
            } else {
                p.next = node;
            }
            node.pre = p;
            p = node;
        }

        return head;
    }

    private static Node clone(Node head) {
        Node p = head;
        Node cloneHead = null;
        Node pre = null;
        while (p != null) {
            Node node = new Node();
            node.data = p.data;
            node.next = null;
            if (cloneHead == null) {
                cloneHead = node;
            } else {
                pre.next = node;
            }
            node.pre = pre;
            pre = node;
            p = p.next;
        }
        return cloneHead;
    }

    private static Node clone1(Node head) {
        if(head==null||head.next==null){
            return head;
        }
        Node p=new Node();
        p.data=head.data;
        Node nexthead=clone1(head.next);
        p.next=nexthead;
        p.pre=null;
        nexthead.pre=p;
        return p;
    }

    private static void print(Node head) {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + "\t");
            p = p.next;
        }
        System.out.println();
    }

    private static void printBackForward(Node tail) {
        Node p = tail;
        while (p != null) {
            System.out.print(p.data + "\t");
            p = p.pre;
        }
        System.out.println();
    }

    private static Node getLastNode(Node head) {
        Node tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4 };
        Node head = create(data);
        print(head);
        Node clone = clone1(head);
        print(clone);
    }
}
